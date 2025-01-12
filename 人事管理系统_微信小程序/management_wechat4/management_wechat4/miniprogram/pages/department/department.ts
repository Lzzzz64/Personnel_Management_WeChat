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
      url: 'http://localhost:8080/department/page',
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

  // 更新部门信息方法，用于在编辑表单页面返回后更新部门信息
  update(updatedDepartment) {
    const index = this.data.listData.findIndex(department => department.departmentId === updatedDepartment.departmentId);
    if (index !== -1) {
      // 找到对应的部门信息，更新数据
      const newListData = this.data.listData;
      newListData[index] = updatedDepartment;
      this.setData({
        listData: newListData,
      });
    }
  },

  handleUpdate(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const department = this.data.listData[index]; // 获取要修改的部门数据
    console.log("要修改的部门数据：", department);

    // 将部门信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/department/departmentUpdate?department=' + JSON.stringify(department),
    });
  },

  handleDelete: function (e) {
    const index = e.currentTarget.dataset.index; // 获取要删除的部门在列表中的索引
    const departmentId = parseInt(this.data.listData[index].departmentId);; // 获取要删除的部门编号
    wx.showModal({
      title: '提示',
      content: '确定要删除该部门吗？',
      success: (res) => {
        if (res.confirm) {
          // 用户点击了确定按钮，向后端发送删除请求
          wx.request({
            url: 'http://localhost:8080/department?departmentId=' + departmentId, // 修改为你的后端接口地址
            method: 'DELETE',
            success: (res) => {
              if (res.data.code === 1) {
                // 删除成功，刷新部门列表
                this.getData();
              } else {
                // 删除失败，显示错误信息
                wx.showToast({
                  title: res.data.msg || '删除失败',
                  icon: 'none'
                });
              }
            },
            fail: (err) => {
              // 请求失败，显示错误提示
              wx.showToast({
                title: '请求失败，请重试',
                icon: 'none'
              });
            }
          });
        }
      }
    });
  },

  add(newDepartment) {
    const listData = this.data.listData;
    listData.push(newDepartment); // 添加新部门到 listData 数组中
    this.setData({
      listData: listData, // 更新页面数据
    });
  },

  // 添加按钮点击事件处理函数
  handleAdd: function () {
    wx.navigateTo({
      url: '/pages/department/departmentAdd', // 跳转到添加部门界面
    });
  },


})