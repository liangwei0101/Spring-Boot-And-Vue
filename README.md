# Spring-Boot-And-Vue

## 记一次Spring booot 和Vue的前后端分离的入门培训

## Vue.js

### 介绍

1. Vue是一套用于构建用户界面的渐进式框架，网址：https://cn.vuejs.org/。

### Vue 建项目

1. Vue 提供了一个官方的 CLI，为单页面应用 (SPA) 快速搭建繁杂的脚手架。基于Vue cli项目脚手架，网址：https://cli.vuejs.org/zh/guide/

2. 

2. 运行以下命令其一来创建一个新项目，有默认选默认即可

    vue create hello-world (命令行)

    vue ui (界面)

3. 在创建好项目以后，运行以下命令将能看到初次项目创建的界面

    cd vue-hello-world

    yarn serve

4. 默认情况下，在 浏览器访问 http://localhost:8080/ 将能看到如下界面：


### Vue 相关结构和生命周期介绍

+ 目录结构如下图：

+ 单个.vue文件的组成部介绍

    ```
    <template>
    <!--html-->
    </template>

    <script>
    //js
    </script>

    <style>
    /* css style */
    </style>
    ```
+ 组件化应用构建

> 使用小型、独立和通常可复用的组件构建大型应用,一个页面如搭积木一样

+ Vue的生命周期

### Vue 常用指令(结合项目中的代码讲解)

+ 声明式渲染

```
<div id="app">
  {{ message }}
</div>
```
```
var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})
```

+ 条件渲染

```
<div id="app-3">
  <p v-if="seen">现在你看到我了</p>
</div>
```

```
var app3 = new Vue({
  el: '#app-3',
  data: {
    seen: true
  }
})
```

+ 循环渲染

```
<div id="app-4">
  <ol>
    <li v-for="todo in todos">
      {{ todo.text }}
    </li>
  </ol>
</div>
```
```
var app4 = new Vue({
  el: '#app-4',
  data: {
    todos: [
      { text: '学习 JavaScript' },
      { text: '学习 Vue' },
      { text: '整个牛项目' }
    ]
  }
})
```
