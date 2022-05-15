<template>
  <div>
    <!-- 工具栏 -->
    <div>
      <div style="display: flex; justify-content: space-between">
        <div>
          <el-input
              style="width: 300px; margin-right: 10px"
              prefix-icon="el-icon-search"
              v-model="empName"
              @keydown.enter.native="initEmps"
              clearable
              @clear="initEmps"
              :disabled="showAdvanceSearchVisible"
              placeholder="请输入员工名进行搜索"
          ></el-input>
          <el-button
              type="primary"
              icon="el-icon-search"
              @click="initEmps"
              :disabled="showAdvanceSearchVisible"
          >搜索
          </el-button
          >
          <el-button
              type="primary"
              @click="showAdvanceSearchVisible = !showAdvanceSearchVisible"
          >
            <!-- fa fa-angle-double-down -->
            <i
                :class="
                showAdvanceSearchVisible
                  ? 'fa fa-angle-double-up'
                  : 'fa fa-angle-double-down'
              "
                aria-hidden="true"
            ></i>
            高级搜索
          </el-button
          >
        </div>
        <div>
          <el-upload
              style="display: inline-flex; margin-right: 10px"
              :headers="headers"
              :show-file-list="false"
              action="/employee/basic/import"
              :before-upload="beforeUpload"
              :on-success="onSuccess"
              :on-error="onError"
              :disabled="importDataDisabled"
          >
            <el-button
                type="success"
                :icon="importDataBtnIcon"
                :disabled="importDataDisabled"
            >
              {{ importDataBtnText }}
            </el-button
            >
          </el-upload>

          <el-button @click="exportData" type="success" icon="el-icon-download">
            导出数据
          </el-button
          >
          <el-button type="primary" icon="el-icon-plus" @click="showAddEmpView"
          >添加员工
          </el-button
          >
        </div>
      </div>
    </div>
    <transition name="slide-fade">
      <div
          style="
          border: 1px solid #409eff;
          border-radius: 5px;
          box-sizing: border-box;
          padding: 5px;
          margin: 10px 0px;
        "
          v-show="showAdvanceSearchVisible"
      >
        <el-row>
          <el-col :span="5"
          >政治面貌：
            <el-select
                v-model="searchValue.politicId"
                size="mini"
                style="width: 130px"
                placeholder="政治面貌"
            >
              <el-option
                  v-for="item in politicsstatus"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
              >
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            民族：
            <el-select
                v-model="searchValue.nationId"
                size="mini"
                style="width: 130px"
                placeholder="民族"
            >
              <el-option
                  v-for="item in nations"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
              >
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="4">
            职位：
            <el-select
                v-model="searchValue.posId"
                size="mini"
                style="width: 130px"
                placeholder="职位"
            >
              <el-option
                  v-for="item in positions"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
              >
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="5">
            职称：
            <el-select
                v-model="searchValue.jobLevelId"
                size="mini"
                style="width: 130px"
                placeholder="职称"
            >
              <el-option
                  v-for="item in joblevels"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
              >
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="6">
            聘用形式：
            <el-radio-group v-model="searchValue.engageForm">
              <el-radio label="劳动合同">劳动合同</el-radio>
              <el-radio label="劳务合同">劳务合同</el-radio>
            </el-radio-group>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="5">
            所属部门：
            <el-popover
                placement="bottom"
                title="请选择所属部门"
                width="200"
                trigger="manual"
                v-model="visible2"
            >
              <el-tree
                  :data="allDeps"
                  :props="defaultProps"
                  default-expand-all
                  @node-click="searchHandleNodeClick"
              ></el-tree>
              <div
                  slot="reference"
                  style="
                  width: 130px;
                  display: inline-flex;
                  border: 1px solid #dedede;
                  height: 25px;
                  border-radius: 5px;
                  cursor: pointer;
                  align-items: center;
                  font-size: 13px;
                  padding-left: 8px;
                  box-sizing: border-box;
                "
                  @click="showDepView2"
              >
                {{ inputDepName }}
              </div>
            </el-popover>
          </el-col>
          <el-col :span="10">
            入职日期：
            <el-date-picker
                v-model="searchValue.beginDateScope"
                type="daterange"
                value-format="yyyy-MM-dd"
                unlink-panels
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                size="mini"
            >
            </el-date-picker>
          </el-col>
          <el-col :span="5" :offset="4">
            <el-button
                size="mini"
                type="primary"
                icon="el-icon-search"
                @click="initEmps('advanced')"
            >搜索
            </el-button
            >
            <el-button size="mini" @click="cancel">取消</el-button>
          </el-col>
        </el-row>
      </div>
    </transition>
    <div style="margin-top: 10px">
      <el-table
          :data="emps"
          border
          stripe
          style="width: 100%"
          v-loading="loading"
          element-loading-text="拼命加载中"
          element-loading-spinner="el-icon-loading"
          element-loading-background="rgba(0, 0, 0, 0.8)"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="name" fixed label="姓名" align="left" width="90">
        </el-table-column>
        <el-table-column prop="workID" label="工号" align="left" width="85">
        </el-table-column>
        <el-table-column
            prop="gender"
            label="性别"
            width="50"
        ></el-table-column>
        <el-table-column
            prop="birthday"
            label="出生日期"
            width="95"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="idCard"
            label="身份证号码"
            align="left"
            width="150"
        ></el-table-column>
        <el-table-column
            prop="wedlock"
            label="婚姻状况"
            width="70"
        ></el-table-column>
        <el-table-column
            prop="nation.name"
            label="民族"
            width="50"
        ></el-table-column>
        <el-table-column
            prop="nativePlace"
            label="籍贯"
            width="80"
        ></el-table-column>
        <el-table-column
            prop="politicsStatus.name"
            label="政治面貌"
            width="100"
        ></el-table-column>
        <el-table-column
            prop="email"
            label="邮箱"
            align="left"
            width="180"
        ></el-table-column>
        <el-table-column
            prop="phone"
            label="电话号码"
            width="100"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="address"
            label="联系地址"
            width="270"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="department.name"
            label="所属部门"
            width="100"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="joblevel.name"
            label="职称"
            width="100"
        ></el-table-column>
        <el-table-column
            prop="position.name"
            label="职位"
            width="100"
        ></el-table-column>
        <el-table-column
            prop="engageForm"
            label="聘用形式"
            width="100"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="tiptopDegree"
            label="最高学历"
            width="80"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="school"
            label="毕业院校"
            width="150"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="specialty"
            label="专业"
            width="150"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="workState"
            label="在职状态"
            width="70"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="beginDate"
            label="入职日期"
            width="95"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="conversionTime"
            label="转正日期"
            width="95"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="beginContract"
            label="合同起始日期"
            width="95"
            align="left"
        ></el-table-column>
        <el-table-column
            prop="endContract"
            label="合同截止日期"
            width="95"
            align="left"
        ></el-table-column>
        <el-table-column label="合同期限" width="100" align="left"
        >
          <template slot-scope="scope">
            <el-tag>{{ scope.row.contractTerm }}
            </el-tag
            >
            年
          </template>
        </el-table-column
        >
        <el-table-column label="操作" fixed="right" width="200">
          <template slot-scope="scope">
            <el-button
                style="padding: 3px"
                size="mini"
                @click="showEditEmpView(scope.row)"
            >编辑
            </el-button
            >
            <el-button style="padding: 3px" size="mini" type="primary"
            >查看高级资料
            </el-button
            >
            <el-button
                style="padding: 3px"
                size="mini"
                type="danger"
                @click="deleteEmp(scope.row)"
            >删除
            </el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <div style="display: flex; justify-content: flex-end">
        <el-pagination
            background
            @current-change="currentChange"
            @size-change="sizeChange"
            layout=" sizes,prev, pager, next, jumper, ->, total, slot"
            :total="total"
        >
        </el-pagination>
      </div>
    </div>
    <el-dialog :title="title" :visible.sync="dialogVisible" width="80%">
      <div>
        <el-form ref="empForm" :model="emp" :rules="rules">
          <el-row>
            <el-col :span="6">
              <el-form-item label="姓名：" prop="name">
                <el-input
                    size="mini"
                    style="width: 150px"
                    prefix-icon="el-icon-edit"
                    v-model="emp.name"
                    placeholder="请输入员工姓名"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="性别：" prop="gender">
                <el-radio-group v-model="emp.gender" style="margin-top: 8px">
                  <el-radio label="男">男</el-radio>
                  <el-radio label="女">女</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="出生日期：" prop="birthday">
                <el-date-picker
                    v-model="emp.birthday"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="出生日期"
                    size="mini"
                    style="width: 150px"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="政治面貌：" prop="politicId">
                <el-select
                    v-model="emp.politicId"
                    size="mini"
                    style="width: 200px"
                    placeholder="政治面貌"
                >
                  <el-option
                      v-for="item in politicsstatus"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="民族：" prop="nationId">
                <el-select
                    v-model="emp.nationId"
                    size="mini"
                    style="width: 150px"
                    placeholder="民族"
                >
                  <el-option
                      v-for="item in nations"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="籍贯：" prop="nativePlace">
                <el-input
                    v-model="emp.nativePlace"
                    placeholder="请输入籍贯"
                    prefix-icon="el-icon-edit"
                    size="mini"
                    style="width: 150px"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="电子邮箱：" prop="email">
                <el-input
                    v-model="emp.email"
                    placeholder="请输入电子邮箱"
                    size="mini"
                    style="width: 150px"
                    prefix-icon="el-icon-message"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="联系地址：" prop="address">
                <el-input
                    v-model="emp.address"
                    placeholder="请输入地址"
                    size="mini"
                    style="width: 200px"
                    prefix-icon="el-icon-location-outline"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="职位：" prop="posId">
                <el-select
                    v-model="emp.posId"
                    size="mini"
                    style="width: 150px"
                    placeholder="职位"
                >
                  <el-option
                      v-for="item in positions"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="职称：" prop="jobLevelId">
                <el-select
                    v-model="emp.jobLevelId"
                    size="mini"
                    style="width: 150px"
                    placeholder="职称"
                >
                  <el-option
                      v-for="item in joblevels"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="所属部门：" prop="departmentId">
                <el-popover
                    placement="bottom"
                    title="请选择所属部门"
                    width="200"
                    trigger="manual"
                    v-model="visible"
                >
                  <el-tree
                      :data="allDeps"
                      :props="defaultProps"
                      default-expand-all
                      @node-click="handleNodeClick"
                  ></el-tree>
                  <div
                      slot="reference"
                      style="
                      width: 150px;
                      display: inline-flex;
                      border: 1px solid #dedede;
                      height: 25px;
                      border-radius: 5px;
                      cursor: pointer;
                      margin-top: 3px;
                      align-items: center;
                      font-size: 13px;
                      padding-left: 8px;
                      box-sizing: border-box;
                    "
                      @click="showDepView"
                  >
                    {{ inputDepName }}
                  </div>
                </el-popover>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="电话号码：" prop="phone">
                <el-input
                    v-model="emp.phone"
                    placeholder="请输入电话号码"
                    size="mini"
                    style="width: 200px"
                    prefix-icon="el-icon-phone"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="工号：" prop="workID">
                <el-input
                    v-model="emp.workID"
                    placeholder="请输入工号"
                    prefix-icon="el-icon-edit"
                    size="mini"
                    style="width: 150px"
                    disabled
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="学历：" prop="tiptopDegree">
                <el-select
                    v-model="emp.tiptopDegree"
                    size="mini"
                    style="width: 150px"
                    placeholder="学历"
                >
                  <el-option
                      v-for="item in tiptopDegrees"
                      :key="item"
                      :label="item"
                      :value="item"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="毕业院校：" prop="school">
                <el-input
                    v-model="emp.school"
                    placeholder="请输入学校"
                    size="mini"
                    style="width: 150px"
                    prefix-icon="el-icon-edit"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="专业名称：" prop="specialty">
                <el-input
                    v-model="emp.specialty"
                    placeholder="请输入专业名称"
                    prefix-icon="el-icon-edit"
                    size="mini"
                    style="width: 200px"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="入职日期：" prop="beginDate">
                <el-date-picker
                    v-model="emp.beginDate"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="入职日期"
                    size="mini"
                    style="width: 150px"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="转正日期：" prop="conversionTime">
                <el-date-picker
                    v-model="emp.conversionTime"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="转正日期"
                    size="mini"
                    style="width: 150px"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="合同起始日期：" prop="beginContract">
                <el-date-picker
                    v-model="emp.beginContract"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="合同起始日期"
                    size="mini"
                    style="width: 150px"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="合同截止日期：" prop="endContract">
                <el-date-picker
                    v-model="emp.endContract"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="合同截止日期"
                    size="mini"
                    style="width: 170px"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="身份证号码：" prop="idCard">
                <el-input
                    v-model="emp.idCard"
                    placeholder="请输入身份证号码"
                    size="mini"
                    prefix-icon="el-icon-edit"
                    style="width: 180px"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="聘用形式：" prop="engageForm">
                <el-radio-group
                    v-model="emp.engageForm"
                    style="margin-top: 8px"
                >
                  <el-radio label="劳动合同">劳动合同</el-radio>
                  <el-radio label="劳务合同">劳务合同</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="婚姻状况：" prop="wedlock">
                <el-radio-group v-model="emp.wedlock" style="margin-top: 8px">
                  <el-radio label="已婚">已婚</el-radio>
                  <el-radio label="未婚">未婚</el-radio>
                  <el-radio label="离异">离异</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="doAddEmp">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'EmpBasic',
  data() {
    return {
      title: '',
      emps: [],
      loading: false,
      total: 0,
      currentPage: 1,
      size: 10,
      empName: '',
      dialogVisible: false,
      emp: {
        id: null,
        name: '',
        gender: '',
        birthday: '',
        idCard: '',
        wedlock: '',
        nationId: null,
        nativePlace: '',
        politicId: null,
        email: '',
        phone: '',
        address: '',
        departmentId: null,
        joblevelId: null,
        posId: null,
        engageForm: '',
        tiptopDegree: '',
        specialty: '',
        school: '',
        beginDate: '',
        workState: '在职',
        workID: '',
        contractTerm: null,
        conversionTime: '',
        notWorkDate: null,
        beginContract: '',
        endContract: '',
        workAge: '',
        salaryId: null,
      },
      nations: [],
      joblevels: [],
      politicsstatus: [],
      positions: [],
      tiptopDegrees: [
        '博士',
        '硕士',
        '本科',
        '大专',
        '高中',
        '初中',
        '小学',
        '其他',
      ],
      visible: false,
      visible2: false,
      defaultProps: {
        children: 'children',
        label: 'name',
      },
      allDeps: [],
      inputDepName: '',
      rules: {
        name: [{required: true, message: '员工名不能为空', trigger: 'blur'}],
        gender: [
          {required: true, message: '员工性别不能为空', trigger: 'blur'},
        ],
        birthday: [
          {required: true, message: '员工出生日期不能为空', trigger: 'blur'},
        ],
        idCard: [
          {
            required: true,
            message: '员工身份证号码不能为空',
            trigger: 'blur',
          },
          {
            pattern:
                /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,
            message: '身份证号码格式不正确',
            trigger: 'blur',
          },
        ],
        wedlock: [
          {required: true, message: '员工婚姻状况不能为空', trigger: 'blur'},
        ],
        nationId: [
          {required: true, message: '员工民族不能为空', trigger: 'blur'},
        ],
        nativePlace: [
          {required: true, message: '员工籍贯不能为空', trigger: 'blur'},
        ],
        politicId: [
          {required: true, message: '员工政治面貌不能为空', trigger: 'blur'},
        ],
        email: [
          {required: true, message: '员工邮箱地址不能为空', trigger: 'blur'},
          {type: 'email', message: '邮箱地址格式不正确', trigger: 'blur'},
        ],
        phone: [
          {
            required: true,
            message: '员工联系电话号码不能为空',
            trigger: 'blur',
          },
        ],
        address: [
          {required: true, message: '员工地址不能为空', trigger: 'blur'},
        ],
        departmentId: [
          {required: true, message: '员工部门名称不能为空', trigger: 'blur'},
        ],
        joblevelId: [
          {required: true, message: '员工职称不能为空', trigger: 'blur'},
        ],
        posId: [
          {required: true, message: '员工职位不能为空', trigger: 'blur'},
        ],
        engageForm: [
          {required: true, message: '员工聘用形式不能为空', trigger: 'blur'},
        ],
        tiptopDegree: [
          {required: true, message: '员工学历信息不能为空', trigger: 'blur'},
        ],
        specialty: [
          {required: true, message: '员工专业不能为空', trigger: 'blur'},
        ],
        school: [
          {required: true, message: '员工毕业院校不能为空', trigger: 'blur'},
        ],
        beginDate: [
          {required: true, message: '员工入职日期不能为空', trigger: 'blur'},
        ],
        workState: [
          {required: true, message: '员工工作状态不能为空', trigger: 'blur'},
        ],
        workID: [
          {required: true, message: '员工工号不能为空', trigger: 'blur'},
        ],
        contractTerm: [
          {required: true, message: '员工合同期限不能为空', trigger: 'blur'},
        ],
        conversionTime: [
          {required: true, message: '员工转正日期不能为空', trigger: 'blur'},
        ],
        notWorkDate: [
          {required: true, message: '员工离职日期不能为空', trigger: 'blur'},
        ],
        beginContract: [
          {
            required: true,
            message: '员工合同起始日期不能为空',
            trigger: 'blur',
          },
        ],
        endContract: [
          {required: true, message: '员工结束不能为空', trigger: 'blur'},
        ],
        workAge: [
          {required: true, message: '员工工龄不能为空', trigger: 'blur'},
        ],
      },
      importDataBtnText: '导入数据',
      importDataBtnIcon: 'el-icon-upload2',
      importDataDisabled: false,
      headers: {
        Authorization: window.sessionStorage.getItem('tokenStr'),
      },
      showAdvanceSearchVisible: false,
      searchValue: {
        politicId: null,
        nationId: null,
        posId: null,
        jobLevelId: null,
        engageForm: '',
        departmentId: null,
        beginDateScope: null,
      },
    }
  },
  methods: {
    initEmps(type) {
      this.loading = true
      let url =
          '/employee/basic/?currentPage=' +
          this.currentPage +
          '&size=' +
          this.size

      if (type && type == 'advanced') {
        if (this.searchValue.politicId) {
          url += '&politicId=' + this.searchValue.politicId
        }
        if (this.searchValue.nationId) {
          url += '&nationId=' + this.searchValue.nationId
        }
        if (this.searchValue.posId) {
          url += '&posId=' + this.searchValue.posId
        }
        if (this.searchValue.jobLevelId) {
          url += '&jobLevelId=' + this.searchValue.jobLevelId
        }
        if (this.searchValue.engageForm) {
          url += '&engageForm=' + this.searchValue.engageForm
        }
        if (this.searchValue.departmentId) {
          url += '&departmentId=' + this.searchValue.departmentId
        }
        if (this.searchValue.beginDateScope) {
          url += '&beginDateScope=' + this.searchValue.beginDateScope
        }
      } else {
        url += '&name=' + this.empName
      }
      console.log(url);
      this.getRequest(url).then((resp) => {
        console.log(resp)
        this.loading = false
        if (resp) {
          this.emps = resp.data
          this.total = resp.total
        }
      })
    },
    currentChange(currentPage) {
      this.currentPage = currentPage
      this.initEmps()
    },
    sizeChange(size) {
      this.size = size
      this.initEmps()
    },
    showAddEmpView() {
      this.title = '添加员工'
      this.emp = {
        id: null,
        name: '',
        gender: '',
        birthday: '',
        idCard: '',
        wedlock: '',
        nationId: null,
        nativePlace: '',
        politicId: null,
        email: '',
        phone: '',
        address: '',
        departmentId: null,
        joblevelId: null,
        posId: null,
        engageForm: '',
        tiptopDegree: '',
        specialty: '',
        school: '',
        beginDate: '',
        workState: '在职',
        workID: '',
        contractTerm: null,
        conversionTime: '',
        notWorkDate: null,
        beginContract: '',
        endContract: '',
        workAge: '',
        salaryId: null,
      }
      this.inputDepName = ''
      this.getMaxWorkID()
      this.initPositions()
      this.dialogVisible = true
    },
    initDate() {
      if (!window.sessionStorage.getItem('nations')) {
        this.getRequest('/employee/basic/nations').then((resp) => {
          if (resp) {
            this.nations = resp
            window.sessionStorage.setItem('nations', JSON.stringify(resp))
          }
        })
      } else {
        this.nations = JSON.parse(window.sessionStorage.getItem('nations'))
      }

      if (!window.sessionStorage.getItem('joblevels')) {
        this.getRequest('/employee/basic/joblevels').then((resp) => {
          if (resp) {
            this.joblevels = resp
            window.sessionStorage.setItem('joblevels', JSON.stringify(resp))
          }
        })
      } else {
        this.joblevels = JSON.parse(window.sessionStorage.getItem('joblevels'))
      }

      if (!window.sessionStorage.getItem('politicsstatus')) {
        this.getRequest('/employee/basic/politicsstatus').then((resp) => {
          if (resp) {
            this.politicsstatus = resp
            window.sessionStorage.setItem(
                'politicsstatus',
                JSON.stringify(resp)
            )
          }
        })
      } else {
        this.politicsstatus = JSON.parse(
            window.sessionStorage.getItem('politicsstatus')
        )
      }

      if (!window.sessionStorage.getItem('allDeps')) {
        this.getRequest('/employee/basic/deps').then((resp) => {
          if (resp) {
            console.log('@', resp)
            this.allDeps = resp
            window.sessionStorage.setItem('allDeps', JSON.stringify(resp))
          }
        })
      } else {
        this.allDeps = JSON.parse(window.sessionStorage.getItem('allDeps'))
      }
    },
    initPositions() {
      this.getRequest('/employee/basic/positions').then((resp) => {
        if (resp) {
          this.positions = resp
        }
      })
    },
    getMaxWorkID() {
      this.getRequest('/employee/basic/maxWorkID').then((resp) => {
        if (resp) {
          this.emp.workID = resp.obj
        }
      })
    },
    showDepView() {
      this.visible = !this.visible
    },
    handleNodeClick(data) {
      this.inputDepName = data.name
      this.emp.departmentId = data.id
      this.visible = !this.visible
    },
    doAddEmp() {
      if (this.emp.id) {
        this.$refs['empForm'].validate((valid) => {
          if (valid) {
            this.putRequest('/employee/basic/', this.emp).then((resp) => {
              if (resp) {
                this.dialogVisible = false
                this.initEmps()
              }
            })
          }
        })
      } else {
        this.$refs['empForm'].validate((valid) => {
          if (valid) {
            this.postRequest('/employee/basic/', this.emp).then((resp) => {
              if (resp) {
                this.dialogVisible = false
                this.initEmps()
              }
            })
          }
        })
      }
    },
    deleteEmp(data) {
      this.$confirm(
          '此操作将永久删除该员工:' + data.name + ', 是否继续?',
          '提示',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            this.deleteRequest('/employee/basic/' + data.id).then((resp) => {
              if (resp) {
                this.initEmps()
              }
            })
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除',
            })
          })
    },
    showEditEmpView(data) {
      this.title = '编辑员工信息'
      this.emp = data
      this.inputDepName = data.department.name
      this.initPositions()
      this.dialogVisible = true
    },
    exportData() {
      this.downloadRequest('/employee/basic/export')
    },
    beforeUpload() {
      this.importDataBtnIcon = 'el-icon-loading'
      this.importDataBtnText = '正在导入'
      this.importDataDisabled = true
    },
    onSuccess() {
      this.importDataBtnIcon = 'el-icon-upload2'
      this.importDataBtnText = '导入数据'
      this.importDataDisabled = false
      this.initEmps()
    },
    onError() {
      this.importDataBtnIcon = 'el-icon-upload2'
      this.importDataBtnText = '导入数据'
      this.importDataDisabled = false
    },
    searchHandleNodeClick(data) {
      this.inputDepName = data.name
      this.searchValue.departmentId = data.id
      this.visible2 = !this.visible2
    },
    showDepView2() {
      this.visible2 = !this.visible2
    },
    cancel() {
      this.searchValue = {
        politicId: null,
        nationId: null,
        posId: null,
        jobLevelId: null,
        engageForm: '',
        departmentId: null,
        beginDateScope: null,
      }
      this.inputDepName = ''
      this.initEmps('advanced')
    }
  },
  mounted() {
    this.initEmps()
    this.initDate()
    this.initPositions()
  },
}
</script>

<style>
/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.slide-fade-enter-active {
  transition: all 0.5s ease;
}

.slide-fade-leave-active {
  transition: all 0.3s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter, .slide-fade-leave-to
  /* .slide-fade-leave-active for below version 2.1.8 */
{
  transform: translateX(10px);
  opacity: 0;
}
</style>
