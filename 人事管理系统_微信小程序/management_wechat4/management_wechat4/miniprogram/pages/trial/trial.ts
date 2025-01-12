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
      url: 'http://localhost:8080/trialPeriod/page',
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
  // 更新信息方法，用于在编辑表单页面返回后更新信息
  update(formData) {
    const index = this.data.listData.findIndex(employee => employee.employeeId === formData.employeeId);
    if (index !== -1) {

      // 找到对应的部门信息，更新数据
      const newListData = this.data.listData;
      newListData[index] = formData;

      this.setData({
        listData: newListData,
      });
    }
  },

  handleMore: function (e) {
    const index = e.currentTarget.dataset.index; // 获取点击按钮的索引
    const operateForm = JSON.stringify(this.data.listData[index]); // 将要修改的部门数据转换为JSON字符串
    console.log("要查看的试用期数据：", operateForm);
    wx.navigateTo({
      url: '/pages/trial/trialMore?operateForm=' + encodeURIComponent(operateForm),
    })
  },

  handleUpdate: function (event) {
    var index = event.currentTarget.dataset.index;
    var employee = this.data.listData[index];
    employee.result = 1;
    var that = this;
    wx.showModal({
      title: '确认转正',
      content: '确定要将员工 ' + employee.employeeName + ' 转为正式员工吗？',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定');
          // 在这里执行转正操作
          wx.request({
            url: 'http://localhost:8080/trialPeriod/update',
            method: 'PUT',
            data: employee,
            header: {
              'content-type': 'application/json' // 设置请求头为JSON格式
            },
            success: function (res) {
              console.log('提交成功：', employee);

              var updatedList = that.data.listData.filter(function (item, idx) {
                return idx !== index;
              });
              that.setData({
                listData: updatedList
              });

              wx.showToast({
                title: '提交成功',
                icon: 'success',
                duration: 2000,
              });
            },
            fail: function (res) {
              console.error('提交失败：', res);
              wx.showToast({
                title: '提交失败',
                icon: 'none',
                duration: 2000
              });
            }
          });
        } else if (res.cancel) {
          console.log('用户点击取消');
        }
      }
    })
  },

  handleDelete: function (event) {
    var index = event.currentTarget.dataset.index;
    var employee = this.data.listData[index];
    var that = this;
    employee.result = 3;
    wx.showModal({
      title: '确认不予录用',
      content: '确定要不录用员工 ' + employee.employeeName + ' 吗？',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定');
          // 在这里执行不予录用操作
          wx.request({
            url: 'http://localhost:8080/trialPeriod/update',
            method: 'PUT',
            data: employee,
            header: {
              'content-type': 'application/json' // 设置请求头为JSON格式
            },
            success: function (res) {
              console.log('提交成功：', employee);

              var updatedList = that.data.listData.filter(function (item, idx) {
                return idx !== index;
              });
              that.setData({
                listData: updatedList
              });

              wx.showToast({
                title: '提交成功',
                icon: 'success',
                duration: 2000,
              });

            },
            fail: function (res) {
              console.error('提交失败：', res);
              wx.showToast({
                title: '提交失败',
                icon: 'none',
                duration: 2000
              });
            }
          });
        } else if (res.cancel) {
          console.log('用户点击取消');
        }
      }
    })
  },
})