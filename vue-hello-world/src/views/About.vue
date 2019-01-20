<template>
  <div class="test">

    <div type="flex" class="right" justify="end">
      <Row type="flex" justify="end" class="code-row-bg">
        <Button type="info" @click="AddBtnShow">新增</Button>
      </Row>
    </div>

    <div>
      <Table border :columns="columns12" :data="data6">
        <template slot-scope="{ row }" slot="name">
          <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" @click="show(index)">View</Button>
          <Button type="error" size="small" @click="remove(index)">Delete</Button>
        </template>
      </Table>
    </div>

    <div>
      <Modal v-model="isAddShow" draggable footer-hide scrollable title="增加用户">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <FormItem label="姓名" prop="name">
            <Input v-model="formValidate.name" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="年龄" prop="mail">
            <Input v-model="formValidate.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem label="地址" prop="mail">
            <Input v-model="formValidate.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

    <div>
      <Modal v-model="isEditShow" draggable footer-hide scrollable title="修改用户">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <FormItem label="工号" prop="name">
            <Input v-model="formValidate.name" placeholder="Enter your name" />
          </FormItem>
          <FormItem label="姓名" prop="mail">
            <Input v-model="formValidate.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem label="邮箱" prop="mail">
            <Input v-model="formValidate.mail" placeholder="Enter your e-mail" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

  </div>
</template>
<script>
  import {
    getMessage
  } from "../api/user.js"
  export default {
    data() {
      return {
        isAddShow: false,
        isEditShow: false,
        columns12: [{
            title: "Name",
            slot: "name"
          },
          {
            title: "Age",
            key: "age"
          },
          {
            title: "Address",
            key: "address"
          },
          {
            title: "Action",
            slot: "action",
            width: 150,
            align: "center"
          }
        ],
        data6: [{
            name: "John Brown",
            age: 18,
            address: "New York No. 1 Lake Park"
          },
          {
            name: "Jim Green",
            age: 24,
            address: "London No. 1 Lake Park"
          },
          {
            name: "Joe Black",
            age: 30,
            address: "Sydney No. 1 Lake Park"
          },
          {
            name: "Jon Snow",
            age: 26,
            address: "Ottawa No. 2 Lake Park"
          }
        ],
        formValidate: {
          name: "",
          mail: "",
          city: ""
        },
        ruleValidate: {
          name: [{
            required: true,
            message: "The name cannot be empty",
            trigger: "blur"
          }],
          mail: [{
              required: true,
              message: "Mailbox cannot be empty",
              trigger: "blur"
            },
            {
              type: "email",
              message: "Incorrect email format",
              trigger: "blur"
            }
          ]
        }
      };
    },
    methods: {
      show(index) {
        this.$Modal.info({
          title: "User Info",
          content: `Name：${this.data6[index].name}<br>Age：${
          this.data6[index].age
        }<br>Address：${this.data6[index].address}`
        });
      },
      remove(index) {
        this.data6.splice(index, 1);
      },
      AddBtnShow() {
        this.handleReset('formValidate')
        this.isAddShow = true
      },
      handleReset (name) {
        this.$refs[name].resetFields();
      }
    },
    mounted() {
      getMessage();
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