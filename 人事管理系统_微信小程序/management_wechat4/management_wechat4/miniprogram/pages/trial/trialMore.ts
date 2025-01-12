Page({
  data: {
    employeeId: '',
    employeeName: '',
    startTime: '', // 试用期开始时间
    endTime: '', // 试用期结束时间
    comment: '', // 试用期部门考核评语
    result: '0', // 考核结果，默认为转正
    processDate: '', // 处理日期
    note: '', // 备注
  },

  onLoad: function (options) {
    // 获取上一个页面传递过来的数据
    const operateForm = JSON.parse(decodeURIComponent(options.operateForm)); // 解析JSON字符串
  
    // 设置数据到页面的data中
    this.setData({
      employeeId: operateForm.employeeId,
      employeeName: operateForm.employeeName,
      startTime: operateForm.startTime || '',
      endTime: operateForm.endTime || '',
      comment: operateForm.comment || '',
      result: operateForm.result || '0',
      processDate: operateForm.processDate || '',
      note: operateForm.note || '',
    });
    console.log(operateForm)
  },

  inputStartTime: function (e) {
    this.setData({
      startTime: e.detail.value
    });
  },

  inputEndTime: function (e) {
    this.setData({
      endTime: e.detail.value
    });
  },

  inputComment: function (e) {
    this.setData({
      comment: e.detail.value
    });
  },

  radioChange: function (e) {
    this.setData({
      result: e.detail.value
    });
  },

  inputProcessDate: function (e) {
    this.setData({
      processDate: e.detail.value
    });
  },

  inputNote: function (e) {
    this.setData({
      note: e.detail.value
    });
  },

  submitForm: function (e ) {
    const formData = {
      employeeId: this.data.employeeId,
      employeeName: this.data.employeeName,
      startTime: this.data.startTime,
      endTime: this.data.endTime,
      comment: this.data.comment,
      result: this.data.result,
      processDate: this.data.processDate,
      note: this.data.note
    };
  
    wx.request({
      url: 'http://localhost:8080/trialPeriod/update',
      method: 'PUT',
      data: formData,
      header: {
        'content-type': 'application/json' // 设置请求头为JSON格式
      },
      success: function (res) {
        console.log('提交成功：', formData);
        wx.showToast({
          title: '提交成功',
          icon: 'success',
          duration: 2000,
          success: function () {
            // 返回上一页
            wx.navigateBack({
              delta: 1,
              success: () => {
                const pages = getCurrentPages();
                const prevPage = pages[pages.length - 1];
                if (prevPage && prevPage.update) {
                  prevPage.update(formData); // 调用上一个页面的更新部门信息方法
                } else {
                  console.error("上一个页面不存在 update 方法");
                }
              }
            });
          }
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
  },
  

  
  cancel: function () {
    wx.navigateBack({
      delta: 1, // 返回页面数，这里假设是返回到上一个页面
    });
  },
});
