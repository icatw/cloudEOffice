<template>
  <div>
    <!-- 工具栏 -->
    <div style="display: flex; justify-content: space-between">
      <el-button type="primary" icon="el-icon-plus" @click="showAddSalaryView"
      >添加工资账套</el-button
      >
      <el-button
          type="success"
          icon="el-icon-refresh"
          @click="initSalaries"
      ></el-button>
    </div>
    <!-- 表格 -->
    <div style="margin-top: 10px">
      <el-table :data="salaries" border stripe>
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column
            prop="name"
            label="账套名称"
            width="120"
        ></el-table-column>
        <el-table-column
            prop="basicsalary"
            label="基本工资"
            width="70"
        ></el-table-column>
        <el-table-column
            prop="trafficsalary"
            label="交通补助"
            width="70"
        ></el-table-column>
        <el-table-column
            prop="lunchsalary"
            label="午餐补助"
            width="70"
        ></el-table-column>
        <el-table-column prop="bonus" label="奖金" width="70"></el-table-column>
        <el-table-column
            prop="createdate"
            label="启用时间"
            width="120"
        ></el-table-column>
        <el-table-column label="养老金" align="center">
          <el-table-column
              prop="pensionper"
              label="比率"
              width="70"
          ></el-table-column>
          <el-table-column
              prop="pensionbase"
              label="基数"
              width="70"
          ></el-table-column>
        </el-table-column>
        <el-table-column label="医疗保险" align="center">
          <el-table-column
              prop="medicalper"
              label="比率"
              width="70"
          ></el-table-column>
          <el-table-column
              prop="medicalbase"
              label="基数"
              width="70"
          ></el-table-column>
        </el-table-column>
        <el-table-column label="公积金" align="center">
          <el-table-column
              prop="accumulationfundper"
              label="比率"
              width="70"
          ></el-table-column>
          <el-table-column
              prop="accumulationfundbase"
              label="基数"
              width="70"
          ></el-table-column>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" @click="showEditSalaryView(scope.row)"
            >编辑</el-button
            >
            <el-button type="danger" @click="deleteSalary(scope.row)"
            >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog :title="dialogTitle" :visible.sync="dialogVisible" width="50%">
      <div
          style="
          display: flex;
          justify-content: space-around;
          align-items: center;
        "
      >
        <el-steps direction="vertical" :active="activeItemIndex">
          <el-step
              :title="itemName"
              v-for="(itemName, index) in salaryItemName"
              :key="index"
          ></el-step>
        </el-steps>
        <el-input
            v-model="salary[title]"
            :placeholder="'请输入' + salaryItemName[index] + '...'"
            v-for="(value, title, index) in salary"
            :key="index"
            v-show="activeItemIndex == index"
            style="width: 200px"
        ></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="preStep">{{
            activeItemIndex == 10 ? '取消' : '上一步'
          }}</el-button>
        <el-button type="primary" @click="nextStep">{{
            activeItemIndex == 10 ? '完成' : '下一步'
          }}</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'SalSob',
  data() {
    return {
      salaries: [],
      dialogVisible: false,
      salaryItemName: [
        '账套名称',
        '基本工资',
        '交通补助',
        '午餐补助',
        '奖金',
        '养老金比率',
        '养老金基数',
        '医疗保险比率',
        '医疗保险基数',
        '公积金比率',
        '公积金基数',
      ],
      activeItemIndex: 0,
      salary: {
        name: '',
        basicsalary: 0,
        trafficsalary: 0,
        lunchsalary: 0,
        bonus: 0,
        pensionper: 0,
        pensionbase: 0,
        medicalper: 0,
        medicalbase: 0,
        accumulationfundper: 0,
        accumulationfundbase: 0,
      },
      dialogTitle: '添加工资账套',
    }
  },
  methods: {
    initSalaries() {
      this.getRequest('/salary/sob/').then((resp) => {
        if (resp) {
          this.salaries = resp
        }
      })
    },
    showAddSalaryView() {
      this.dialogTitle = '添加工资账套'
      this.salary = {
        name: '',
        basicsalary: 0,
        trafficsalary: 0,
        lunchsalary: 0,
        bonus: 0,
        pensionper: 0,
        pensionbase: 0,
        medicalper: 0,
        medicalbase: 0,
        accumulationfundper: 0,
        accumulationfundbase: 0,
      }
      this.activeItemIndex = 0
      this.dialogVisible = true
    },
    nextStep() {
      if (this.activeItemIndex == 10) {
        if (this.salary.id) {
          this.putRequest('/salary/sob/', this.salary).then((resp) => {
            if (resp) {
              this.initSalaries()
              this.dialogVisible = false
            }
          })
        } else {
          this.postRequest('/salary/sob/', this.salary).then((resp) => {
            console.log(this.salary)
            if (resp) {
              this.initSalaries()
              this.dialogVisible = false
            }
          })
        }
      }
      this.activeItemIndex++
    },
    preStep() {
      if (this.activeItemIndex == 0) {
        return
      } else if (this.activeItemIndex == 10) {
        this.dialogVisible = false
        return
      }
      this.activeItemIndex--
    },
    deleteSalary(data) {
      this.$confirm(
          '此操作将永久删除' + data.name + '工资账套, 是否继续?',
          '提示',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            this.deleteRequest('/salary/sob/' + data.id).then((resp) => {
              if (resp) {
                this.initSalaries()
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
    showEditSalaryView(data) {
      this.dialogTitle = '编辑工资账套'
      this.activeItemIndex = 0
      this.salary.id = data.id
      this.salary.name = data.name
      this.salary.basicsalary = data.basicsalary
      this.salary.trafficsalary = data.trafficsalary
      this.salary.lunchsalary = data.lunchsalary
      this.salary.bonus = data.bonus
      this.salary.pensionper = data.pensionper
      this.salary.pensionbase = data.pensionbase
      this.salary.medicalper = data.medicalper
      this.salary.medicalbase = data.medicalbase
      this.salary.accumulationfundper = data.accumulationfundper
      this.salary.accumulationfundbase = data.accumulationfundbase
      this.dialogVisible = true
    },
  },
  mounted() {
    this.initSalaries()
  },
}
</script>

<style>
</style>
