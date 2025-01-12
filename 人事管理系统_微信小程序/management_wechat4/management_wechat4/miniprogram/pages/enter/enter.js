// pages/2/2.ts
Page({

  /**
   * 页面的初始数据
   */
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
      url: 'http://localhost:8080/employee/page',
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
  
  handleSearch(e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const employee = this.data.listData[index]; // 获取员工数据
    console.log("要查询的员工数据：", employee);

    // 将员工信息传递给编辑表单页面
    wx.navigateTo({
      url: '/pages/search/search?employee=' + JSON.stringify(employee),
    });
  },
  handleEnter(e){
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const employee = this.data.listData[index]; // 获取员工数据
    console.log("员工数据：", employee);
    const employeeId = parseInt(this.data.listData[index].employeeId);; // 获取员工编号
    wx.showModal({
      title: '提示',
      content: '确定入职吗？',
      success: (res) => {
        if (res.confirm) {
          // 用户点击了确定按钮，向后端发送请求
          wx.request({
            url: 'http://localhost:8080/employee/updateStatus?employeeId=' + employeeId, // 修改为你的后端接口地址
            method: 'GET',
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

  /**
   * 生命周期函数--监听页面加载
   */

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})