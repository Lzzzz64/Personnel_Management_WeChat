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
  },
  getData() {
    // 发送网络请求
    wx.request({
      url: 'http://localhost:8080/foreign/page',
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
      url: '/pages/employee/foreignQuery?employee=' + JSON.stringify(employee),
    });
  },

  // add(newDepartment) {
  //   const listData = this.data.listData;
  //   listData.push(newDepartment); // 添加新部门到 listData 数组中
  //   this.setData({
  //     listData: listData, // 更新页面数据
  //   });
  // },

  //添加按钮点击事件处理函数
  handleAdd(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const employee = this.data.listData[index]; // 获取要修改的部门数据
    console.log("要添加的员工数据：", employee);

    // 将员工信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/employee/foreignAdd?employee=' + JSON.stringify(employee),
    });
  },

})

  // 更新部门信息方法，用于在编辑表单页面返回后更新部门信息
  // update(queryForeign) {
  //   const index = this.data.listData.findIndex(employee => employee.employeeId === queryForeign.employeeId);
  //   if (index !== -1) {
  //     // 找到对应的部门信息，更新数据
  //     const newListData = this.data.listData;
  //     newListData[index] = queryForeign;
  //     this.setData({
  //       listData: newListData,
  //     });
  //   }
  // },