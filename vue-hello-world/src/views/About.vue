<template>
  <div class="test">
    <div type="flex" class="right" justify="end">
         <Row type="flex" justify="end" class="code-row-bg">
                 <Button type="info">Info</Button>
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
  </div>
</template>
<script>
  import {getMessage} from '../api/user.js'
  export default {
    data() {
      return {
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
        ]
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
      }
    },
    mounted() {
      getMessage()
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .test {
    margin: 20px;
  }

  .right {
    margin:15px;
  }
</style>