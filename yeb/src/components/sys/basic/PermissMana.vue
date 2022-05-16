<template>
  <div>
    <div class="permissManaTool">
      <el-input size="small" placeholder="请输入角色英文名" v-model="role.name">
        <template slot="prepend">ROLE_</template>
      </el-input>
      <el-input
        v-model="role.nameZh"
        placeholder="请输入角色中文名"
        size="small"
        @keydown.enter.native="doAddRole"
      ></el-input>
      <el-button
        type="primary"
        size="small"
        icon="el-icon-plus"
        @click="doAddRole"
        >添加角色</el-button
      >
    </div>
    <!-- 手风琴 -->
    <div class="permissManaMain">
      <el-collapse accordion @change="change" v-model="activeName">
        <el-collapse-item
          :title="r.nameZh"
          :name="r.id"
          v-for="(r, index) in roles"
          :key="index"
        >
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>可访问资源</span>
              <el-button
                style="float: right; padding: 3px 0; color: #ff0000"
                type="text"
                icon="el-icon-delete"
                @click="doDeleteRole(r)"
              ></el-button>
            </div>
            <div>
              <!-- 树形控件 -->
              <el-tree
                show-checkbox
                :data="allMenus"
                :props="defaultProps"
                ref="tree"
                :default-checked-keys="selectedMenus"
                node-key="id"
                :key="index"
              ></el-tree>
              <div style="display: flex; justify-content: flex-end">
                <el-button size="mini" @click="cancelUpdate"
                  >取消修改</el-button
                >
                <el-button
                  type="primary"
                  size="mini"
                  @click="doUpdate(r.id, index)"
                  >确认修改</el-button
                >
              </div>
            </div>
          </el-card>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PermissMana',
  data() {
    return {
      role: {
        name: '',
        nameZh: '',
      },
      roles: [],
      allMenus: [],
      defaultProps: {
        children: 'children',
        label: 'name',
      },
      selectedMenus: [],
      activeName: -1,
    }
  },
  methods: {
    initRoles() {
      this.getRequest('/system/basic/permiss/').then((resp) => {
        if (resp) {
          this.roles = resp
        }
      })
    },
    change(rid) {
      if (rid) {
        this.initAllMenus()
        this.initSelectedMenus(rid)
      }
    },
    initAllMenus() {
      this.getRequest('/system/basic/permiss/menus').then((resp) => {
        if (resp) {
          this.allMenus = resp
        }
      })
    },
    initSelectedMenus(rid) {
      this.getRequest('/system/basic/permiss/mid/' + rid).then((resp) => {
        if (resp) {
          this.selectedMenus = resp
        }
      })
    },
    doUpdate(rid, index) {
      let tree = this.$refs.tree[index]
      let selectedKeys = tree.getCheckedKeys(true)
      let url = '/system/basic/permiss/?rid=' + rid
      selectedKeys.forEach((key) => {
        url += '&mids=' + key
      })
      this.putRequest(url).then((resp) => {
        if (resp) {
          this.activeName = -1
          this.initSelectedMenus(rid)
        }
      })
    },
    cancelUpdate() {
      this.activeName = -1
    },
    doAddRole() {
      if (this.role.name && this.role.nameZh) {
        this.postRequest('/system/basic/permiss/', this.role).then((resp) => {
          if (resp) {
            this.initRoles()
            this.role.name = ''
            this.role.nameZh = ''
          }
        })
      } else {
        this.$message.error('英文名和中文名都必须填写')
      }
    },
    doDeleteRole(role) {
      this.$confirm('此操作将删[' + role.nameZh + ']角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          this.deleteRequest('/system/basic/permiss/role/' + role.id).then(
            (resp) => {
              if (resp) {
                this.initRoles()
              }
            }
          )
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
  },
  mounted() {
    this.initRoles()
  },
}
</script>

<style>
.permissManaTool {
  display: flex;
  justify-content: flex-start;
}
.permissManaTool .el-input {
  width: 300px;
  margin-right: 6px;
}
.permissManaMain {
  margin-top: 10px;
  width: 700px;
}
</style>