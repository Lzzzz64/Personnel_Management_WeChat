Page({
  data: {
    listData: [], // 表格数据
    totalItems: 0, // 总条数
    pageSize: 10, // 每页显示条数
    currentPage: 1,// 当前页码
  },
  onLoad() {
    // 页面加载时发送请求获取数据
    this.getData();
    console.log(listData);
  },
  getData() {
    // 发送网络请求
    wx.request({
      url: 'http://localhost:8080/relation/page',
      data: {
        // 传递分页参数
        pageNum: 0,
        pageSize: 500
      },
      success: (res) => {
        if (res.data.code === 1) {
          console.log(res.data.data.records),
            // 更新数据
            this.setData({
              listData: res.data.data.records,
              totalItems: res.data.data.total,
            });
        } else {
          wx.showToast({
            title: '获取数据失败',
            icon: 'none'
          });
        }
      },
      fail: () => {
        wx.showToast({
          title: '网络请求失败',
          icon: 'none'
        });
      }
    });
  },


  handleQuery(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const employee = this.data.listData[index]; // 获取要修改的部门数据
    console.log("要修改的员工数据：", employee);

    // 将员工信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/employee/familyQuery?employee=' + JSON.stringify(employee),
    });
  },

  //添加按钮点击事件处理函数
  handleAdd(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const employee = this.data.listData[index]; // 获取要修改的部门数据
    console.log("要添加的员工数据：", employee);

    // 将员工信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/employee/familyAdd?employee=' + JSON.stringify(employee),
    });
  },

})