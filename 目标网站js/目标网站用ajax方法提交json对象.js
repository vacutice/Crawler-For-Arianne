//网站源码中的关键位置
  //发送请求的入口，在发送请求前会对输入的数据做一些处理，但是其实不必关心
  sendForm: function(e, t, n) {
                return new Promise(function(r, i) {
                    n.startProcessing(),



  //到此为止，请求已经构造完成。监视method, url和data
  i.forEach(["post", "put", "patch"], function(e) {
            s.prototype[e] = function(t, n, r) {
                return this.request(i.merge(r || {}, {
                    method: e,
                    url: t,
                    data: n
                }))

//在浏览器控制台模拟
$.ajax({url: 'https://www.docdroid.net/cUX0hjn/password', type:'POST', headers:{"x-csrf-token": window.Spark.csrfToken},processData:false,data: JSON.stringify({password:'Sunspear',errors:{errors:{}},busy:true,successful:false}),contentType:"application/json;charset=UTF-8",success: function(res){ alert('we are good');window.open('https://www.docdroid.net/cUX0hjn/')},complete: function(res,sta){ console.log(res)}});