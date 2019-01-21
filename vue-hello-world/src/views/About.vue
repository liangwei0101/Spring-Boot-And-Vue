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
        <template slot-scope="{ row, index }" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" >View</Button>
          <Button type="error" size="small" @click="remove(index)">Delete</Button>
        </template>
      </Table>
    </div>

    <!-- 增加用户 -->
    <div>
      <Modal v-model="isAddShow" draggable footer-hide scrollable title="增加用户">
        <Form ref="addFormList" :model="addFormList" :rules="ruleValidate" :label-width="80">
          <FormItem label="编号" prop="no">
            <Input v-model="addFormList.no" placeholder="请输入你的编号" />
          </FormItem>
          <FormItem label="姓名" prop="name">
            <Input v-model="addFormList.name" placeholder="请输入你的姓名" />
          </FormItem>
          <FormItem label="邮箱" prop="email">
            <Input v-model="addFormList.email" placeholder="请输入你的邮箱" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="AddUserSubmit()">提交</Button>
            <Button @click="handleReset('addFormList')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

  <!-- 修改用户 -->
    <!-- <div>
      <Modal v-model="isEditShow" draggable footer-hide scrollable title="修改用户">
        <Form ref="ruleValidate" :model="addFormList" :rules="ruleValidate" :label-width="80">
          <FormItem label="工号" prop="id">
            <Input v-model="addFormList.name" placeholder="Enter your name" />
          </FormItem>
          <FormItem label="姓名" prop="name">
            <Input v-model="addFormList.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem label="邮箱" prop="mail">
            <Input v-model="addFormList.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
          </FormItem>
        </Form>
      </Modal>
    </div> -->

  </div>
</template>
<script>
  import { UserQryAction , UserAddAction} from "../api/user.js"
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
        ruleValidate: {
          id: [{
            required: true,
            message: "编号不能为空！",
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
            },
            {
              type: "email",
              message: "不合法的邮箱！",
              trigger: "blur"
            }
          ]
        }
      };
    },
    methods: {
      UserQry () {
        UserQryAction().then(res => {
          this.dataList = res.data
        })
      },
      UserAdd (user) {
        UserAddAction(user).then(res => {
          this.AddBtnNotShow()
          this.UserQry()
          this.$Message.success('增加成功！')
        })
      },
      remove (index) {
        
      },
      AddUserSubmit () {
        this.UserAdd(this.addFormList)
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