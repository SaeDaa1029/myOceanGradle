
$("article div.LinkAccordion__AccordionContainer-sc-1o112j5-1.cJPEO").on("click", "#noticeWrap", function(){
    if($("#notice").attr("class")== "Accordion__Content-sc-1jd6vdl-3 zRWUs"){
        $("#notice").attr("class", "Accordion__Content-sc-1jd6vdl-3 bJFgwb");
    } else{
        $("#notice").attr("class", "Accordion__Content-sc-1jd6vdl-3 zRWUs");
    }
})

$("#refundWrap").on("click", function(){
    if($("#refund").attr("class")== "Accordion__Content-sc-1jd6vdl-3 zRWUs"){
        console.log("열림");
        $("#refund").attr("class", "Accordion__Content-sc-1jd6vdl-3 bJFgwb");
    }else{
        console.log("닫힘");
        $("#refund").attr("class", "Accordion__Content-sc-1jd6vdl-3 zRWUs");
    }
})


// 참여하기
$(".joinGroup").on("click", function(){
    if(confirm("[" + $(".BasicInfoSection__Title-sc-1f238bn-5.cWsrnE").text() + "] 모임 참여를 하시면 " + $(".PriceInfo__PriceUnit-sc-1s3i0u7-3.kWprXL").text() + "포인트가 차감됩니다.\n참여하시겠습니까?" )){ // 확인 버튼을 눌렀을 때
        $.ajax({
            url: "/host/group-member/" + $(".goUpdate").attr("href"),
            type: "post",
            async: false,
            success: function(result, status, xhr) {
                result == true ? alert("참여 완료되었습니다.") : alert("잔여 포인트가 부족하여 모임 참여가 불가합니다.");
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
        location.href= "/host/group-list";
    }else{  // 취소 버튼을 눌렀을 때
        alert("취소 되었습니다.");
    }
})

/*모임 신청 취소*/
$(".cancelGroup").on("click", function(){
    if(confirm("[" + $(".BasicInfoSection__Title-sc-1f238bn-5.cWsrnE").text() + "] 모임 참여를 취소하시겠습니까?\n포인트 환불은 관리자 확인에 따라 며칠의 기간이 소요될 수 있습니다.")) {
        $.ajax({
            url: "/host/group-member-delete/" + $(".goUpdate").attr("href"),
            type: "post",
            async: false,
            success: function (result, status, xhr) {
                alert("모임 참여가 취소되었습니다.");
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
        location.href= "/host/group-list";
    }else{
        ;
    }



})