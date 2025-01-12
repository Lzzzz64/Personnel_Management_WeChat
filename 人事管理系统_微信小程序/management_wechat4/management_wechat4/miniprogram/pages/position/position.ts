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
      url: 'http://localhost:8080/position/page',
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

  // 更新岗位信息方法，用于在编辑表单页面返回后更新岗位信息
  update(updatedPosition) {
    const index = this.data.listData.findIndex(position => position.positionId === updatedPosition.positionId);
    if (index !== -1) {
      // 找到对应的岗位信息，更新数据
      const newListData = this.data.listData;
      newListData[index] = updatedPosition;
      this.setData({
        listData: newListData,
      });
    }
  },

  handleUpdate(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const position = this.data.listData[index]; // 获取要修改的岗位数据
    console.log("要修改的部门数据：", position);

    // 将岗位信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/position/positionUpdate?position=' + JSON.stringify(position),
    });
  },

  handleDelete: function (e) {
    const index = e.currentTarget.dataset.index; // 获取要删除的岗位在列表中的索引
    const positionId = parseInt(this.data.listData[index].positionId);; // 获取要删除的岗位编号
    wx.showModal({
      title: '提示',
      content: '确定要删除该岗位吗？',
      success: (res) => {
        if (res.confirm) {
          // 用户点击了确定按钮，向后端发送删除请求
          wx.request({
            url: 'http://localhost:8080/position?positionId=' + positionId, // 修改为你的后端接口地址
            method: 'DELETE',
            success: (res) => {
              if (res.data.code === 1) {
                // 删除成功，刷新岗位列表
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

  add(newPosition) {
    const listData = this.data.listData;
    listData.push(newPosition); // 添加新岗位到 listData 数组中
    this.setData({
      listData: listData, // 更新页面数据
    });
  },

  // 添加按钮点击事件处理函数
  handleAdd: function () {
    wx.navigateTo({
      url: '/pages/position/positionAdd', // 跳转到添加岗位界面
    });
  },


})