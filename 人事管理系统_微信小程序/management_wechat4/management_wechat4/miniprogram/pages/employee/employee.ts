Page({
  data: {
    listData: [], // 表格数据
    totalItems: 0, // 总条数
    pageSize: 10, // 每页显示条数
    currentPage: 1,// 当前页码
  },
  handleCareer: function () {
    wx.navigateTo({
      url: '/pages/employee/career', // 跳转到添加部门界面
    });
  },
  handleForeign: function () {
    wx.navigateTo({
      url: '/pages/employee/foreign', // 跳转到添加部门界面
    });
  },
  handleFamily: function () {
    wx.navigateTo({
      url: '/pages/employee/family', // 跳转到添加部门界面
    });
  },

  handleTrial: function () {
    wx.navigateTo({
      url: '/pages/trial/trial', // 跳转到添加部门界面
    });
  },

  handleInfo: function () {
    wx.navigateTo({
      url: '/pages/2/2', // 跳转到添加部门界面
    });
  },
})