$(document).ready(function() {
    $("#addClubBtn").click(function () {
        $('#loginModalId').modal('show');
        $('#createTime').removeAttr("readonly");
        $('#type').removeAttr("readonly");
        $('#activityNum').removeAttr("readonly");
        $("#createTime").attr("type","date");
        $("#myModalLabel").val("新增");
        getType();
    });
    $("#cancelSave").click(function () {
        window.location="index.html";
    });
    if ($("#deleteResult").val().length>0) alert($("#deleteResult").val());
    $("#hiddenWindow").click(function () {
        window.location="index.html";
    });
    $("#saveModalYesId").click(function () {
       if ($("#name").val()==null||$("#name").val()==""){
            alert("俱乐部名称不能为空");
        }
        else  if ($("#manager").val()==null||$("#manager").val()==""){
            alert("负责人不能为空");
        }
        else  if ($("#createTime").val()==null||$("#createTime").val()==""){
            alert("创建时间不能为空");
        }
        else if ($("#activityNum").val()==null||$("#activityNum").val()==""){
            alert("活动次数不能为空");
        }
        else if ($("#members").val()==null||$("#members").val()==""){
            alert("会员数量不能为空");
        }else{
            $('#loginModalId').modal('hide');
            var url;
            if ($("#myModalLabel").val()=="新增"){
                url = "addClub";
            }else {
                url ="editClub";
            }
            $.ajax({
                type:"post",
                url:url,
                data:{id:$("#editId").val(),name:$("#name").val(),manager:$("#manager").val(),createTime:$("#createTime").val(),typeId:$("#type").val(),activityNum:$("#activityNum").val(),members:$("#members").val()},
                success:function (result) {
                    window.location="index.html";
                    alert(result);
                }
            });
        }
    });
});
function editClub() {
    $(function () {
        if ($("#isEdit").val()==1){
            $('#loginModalId').modal('show');
            $("#myModalLabel").text("修改");
           getClubInfo();
        }
    })
}
function getType() {
    $.ajax({
        type:"get",
        url:"getAllType",
        success:function (result) {
            $("#type").empty();
            $.each(result,function (index,value) {
                $("#type").append('<option value="'+value.id+'">'+value.name+'</option>');
            })
        }
    });
}
function getClubInfo() {
    $.ajax({
        type:"get",
        url:"getClubById?id="+$("#editId").val(),
        success:function (result) {
           $("#name").val(result.name);
           $("#manager").val(result.manager);
            $("#type").append('<option value="'+result.id+'">'+result.type+'</option>');
            $("#type").attr("readonly","readonly");
            var date=new Date(result.createTime);
            var newDate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDay();
           $("#createTime").attr("type","text");
           $("#createTime").val(newDate);
            $("#createTime").attr("readonly","readonly");
           $("#activityNum").val(result.activityNum);
            $("#activityNum").attr("readonly","readonly");
           $("#members").val(result.members);
        }
    });
}