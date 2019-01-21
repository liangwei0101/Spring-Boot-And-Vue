<template>
  <div class="test">

    <!-- 按钮 -->
    <div type="flex" class="right" justify="end">
      <Row type="flex" justify="end" class="code-row-bg">
        <Button type="info" @click="AddBtnShow()">新增</Button>
      </Row>
    </div>

    <!-- 列表 -->
    <div>
      <Table border :columns="columns" :data="dataList">
        <template slot-scope="{row}" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" >修改</Button>
          <Button type="error" size="small" @click="UserDel(row)">删除</Button>
        </template>
      </Table>
    </div>

    <!-- 增加用户 -->
    <div>
      <Modal v-model="isAddShow" draggable footer-hide scrollable title="增加用户">
        <Form ref="addFormList" :model="addFormList" :rules="ruleValidate" :label-width="80">
          <FormItem label="编号" prop="no">
            <Input v-model="addFormList.no" placeholder="请输入你的编号" number />
          </FormItem>
          <FormItem label="姓名" prop="name">
            <Input v-model="addFormList.name" placeholder="请输入你的姓名" />
          </FormItem>
          <FormItem label="邮箱" prop="email">
            <Input v-model="addFormList.email" placeholder="请输入你的邮箱" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('addFormList')">提交</Button>
            <Button @click="handleReset('addFormList')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

  <!-- 修改用户 -->
    <div>
      <Modal v-model="isEditShow" draggable footer-hide scrollable title="修改用户">
        <Form ref="editFormList" :model="editFormList" :rules="ruleValidate" :label-width="80">
          <FormItem label="工号" prop="id">
            <Input v-model="editFormList.name" placeholder="Enter your name" />
          </FormItem>
          <FormItem label="姓名" prop="name">
            <Input v-model="editFormList.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem label="邮箱" prop="mail">
            <Input v-model="editFormList.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('editFormList')">提交</Button>
            <Button @click="handleReset('editFormList')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

  </div>
</template>
<script>
  import { UserQryAction , UserAddAction, UserDelAction} from "../api/user.js"
  export default {
    data() {
      return {
        isAddShow: false,
        isEditShow: false,
        columns: [{
            title: "编号",
            key: "no"
          },
          {
            title: "名称",
            key: "name"
          },
          {
            title: "邮箱",
            key: "email"
          },
          {
            title: "操作",
            slot: "action",
            width: 150,
            align: "center"
          }
        ],
        dataList: [],
        addFormList: {
          no: "",
          name: "",
          email: ""
        },
        editFormList: {
          no: "",
          name: "",
          email: ""
        },
        ruleValidate: {
          no: [{
            required: true,
            type: "number",
            message: "编号只能为数字！",
            trigger: "blur"
          }],
          name: [{
            required: true,
            message: "姓名不能为空！",
            trigger: "blur"
          }],
          email: [{
              required: true,
              message: "邮箱不能为空！",
              trigger: "blur"
            },{
              type: "email",
              message: "不合法的邮箱！",
              trigger: "blur"
            }]
        }
      };
    },
    methods: {
      UserQry () {
        UserQryAction().then(res => {
          this.dataList = res.data
        })
      },
      UserAdd () {
        UserAddAction(this.addFormList).then(res => {
          this.AddBtnNotShow()
          this.UserQry()
          this.$Message.success('增加成功！')
        })
      },
      UserDel (item) {
          console.log(item)
          UserDelAction(item.no).then(res => {
          this.UserQry()
          this.$Message.success('删除成功！')
        })
      },
      handleSubmit (name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.UserAdd()
          } else {
              this.$Message.error('信息错误!')
          }
        })
      },
      AddBtnShow() {
        this.handleReset('addFormList')
        this.isAddShow = true
      },
      AddBtnNotShow() {
        this.isAddShow = false
      },
      handleReset (name) {
        this.$refs[name].resetFields();
      }
    },
    mounted() {
      this.UserQry()
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .test {
    margin: 20px;
  }

  .right {
    margin: 15px;
  }
</style>