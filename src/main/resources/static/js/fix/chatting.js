$chatDateLine = $(".chattingWrap .chattingContentWrap .chattingSection .chattingRoom .chattingRoomWrap .dayInfo");



checkChatMedia();

/*반응형*/
function checkChatMedia() {
    if (window.innerWidth < 769) {
        //채팅창 썸네일 이미지 삭제
        $(".chatThumb").css("display", "none");
        //채팅창 활성화 시작 시간 삭제
        $(".beforeTime").css("display", "none");
        //채팅창 활성화 종료 시간 삭제
        $(".endTime").css("display", "none");
        //채팅창 설명 삭제
        $(".chatInfoTxt").css("display", "none");
        //채팅 내역에서 날짜 옆 선 길이 조정
        $chatDateLine.attr("class", "dayInfo media");

    } else {
        //채팅창 썸네일 이미지 살리기
        $(".chatThumb").css("display", "block");
        //채팅창 활성화 시작 시간 삭제
        $(".beforeTime").css("display", "block");
        //채팅창 활성화 종료 시간 삭제
        $(".endTime").css("display", "block");
        //채팅창 설명 삭제
        $(".chatInfoTxt").css("display", "block");
        //채팅 내역에서 날짜 옆 선 길이 조정
        $chatDateLine.attr("class", "dayInfo");
    }
}

$(window).resize(function () {
    if (window.innerWidth < 769) {
        //채팅창 썸네일 이미지 삭제
        $(".chatThumb").css("display", "none");
        //채팅창 활성화 시작 시간 삭제
        $(".beforeTime").css("display", "none");
        //채팅창 활성화 종료 시간 삭제
        $(".endTime").css("display", "none");
        //채팅창 설명 삭제
        $(".chatInfoTxt").css("display", "none");
        //채팅 내역에서 날짜 옆 선 길이 조정
        $chatDateLine.attr("class", "dayInfo media");


    } else {
        //채팅창 썸네일 이미지 살리기
        $(".chatThumb").css("display", "block");
        //채팅창 활성화 시작 시간 삭제
        $(".beforeTime").css("display", "block");
        //채팅창 활성화 종료 시간 삭제
        $(".endTime").css("display", "block");
        //채팅창 설명 삭제
        $(".chatInfoTxt").css("display", "block");
        //채팅 내역에서 날짜 옆 선 길이 조정
        $chatDateLine.attr("class", "dayInfo");
    }
})





/* 채팅창 닫기 누르면 다시 원상복귀 */
$(".foldChatBtn").on("click", function () {
    $("#chattingList").css("display", "none");
    $(".chattingWrap2").css("display", "block");
    $("#chattingList").children("li").removeClass("select");

})


/* 대화방 나가기 버튼을 누르면 나오는 모달 */
$(".moreBtn").on("click", function () {
    let name = $(this).closest("#chattingList").find(".chattingRoomName").text();
    let text = "";
    text += `<p class="modalTit">` + name + `</p>`
    text += `<p class="modalTit">채팅방을 나가시겠습니까?</p>`
    $(".chatExitModal .chatExit .inputChattingName").html(text);
    $(".chatExitModal").css("display", "block");
})


/* 나가기 누르면 나오는 모달에서 예, 아니오, 엑스를 누르면 모달창 닫기 */
$(".closeBtn").on("click", function () {
    $(".chatExitModal").css("display", "none");
})

$(".whiteBtn").on("click", function () {
    $(".chatExitModal").css("display", "none");
})

$(".redBtn").on("click", function () {
    $(".chatExitModal").css("display", "none");
})


/* 처음 대화를 시도하는 상대방의 1:1 대화 버튼을 누르면 나오는 모달 */
$(".pinkBtn").on("click", function () {
    let name = $(this).closest(".profileInfoTxt").find(".name").text();
    let text = "";
    text += `<p>예를 누르시면,</p>`
    text += `<p>` + name + `님과 대화를 시작합니다!` + `</p>`
    $(".request_chat .commonModal .commonModalContent").html(text);
    $(".request_chat").css("display", "block");
})


/* 에, 아니오, 엑스 누르는 부분. 예를 누르면 채팅창이 열린다. */
$(".closeBtn").on("click", function () {
    $(".request_chat").css("display", "none");
})

$(".whiteBtn").on("click", function () {
    $(".request_chat").css("display", "none");
})

$(".chatStart").on("click", function () {
    $(".request_chat").css("display", "none");
    $(".chattingWrap2").css("display", "none");
    $("#chattingList").css("display", "block");
})


/* 여러 부분에서 1:1 채팅을 누르면 이름을 가져와서 모달창 뜨게 하는 부분 */
$(".chat").on("click", function () {
    let name = $(this).closest(".letspler_Re").find(".name").text();
    let text = "";
    text += `<p>예를 누르시면,</p>`
    text += `<p>` + name + `님과 대화를 시작합니다!` + `</p>`
    $(".request_chat .commonModal .commonModalContent").html(text);
    $(".request_chat").css("display", "block");
})

$(".letspler_Re .bottom .chatBtn").on("click", function () {
    let name = $(this).closest(".letspler_Re").find(".name").text();
    let text = "";
    text += `<p>예를 누르시면,</p>`
    text += `<p>` + name + `님과 대화를 시작합니다!` + `</p>`
    $(".request_chat .commonModal .commonModalContent").html(text);
    $(".request_chat").css("display", "block");
})

$(".chatMini").on("click", function () {
    let name = $(this).closest(".right").find(".nameMini").text();
    let text = "";
    text += `<p>예를 누르시면,</p>`
    text += `<p>` + name + `님과 대화를 시작합니다!` + `</p>`
    $(".request_chat .commonModal .commonModalContent").html(text);
    $(".request_chat").css("display", "block");
})


/* 이미 대화중일 때 뜨는 모달 */
$(".already_chat_btn").click(function () {
    let name = $(this).closest(".profileInfoTxt").find(".name").text();
    let text = "";
    text += `<p class="modalTit"><span>` + name + `</span>님과</p>`
    text += `<p class="modalTit">대화가 진행중입니다.</p>`

    $(".already_chat .commonModal .tit").html(text);
    $(".already_chat").css("display", "block");
});

$(".chatStart").on("click", function () {
    $(".already_chat").css("display", "none");
    $(".chattingWrap2").css("display", "none");
    $("#chattingList").css("display", "block");
})

$(".closeBtn").on("click", function () {
    $(".already_chat").css("display", "none");
})

$(".whiteBtn").on("click", function () {
    $(".already_chat").css("display", "none");
})


$(".mentions__control").on("keyup", function (key) {
    if (key.keyCode == 13) {
        $(".mentions--multiLine").attr("style",)
    }
});


/*==============================================================================================================================================*/
/*==============================================================================================================================================*/
/*==============================================================================================================================================*/
/*==============================================================================================================================================*/
let webSocket;
function connect(){
    webSocket = new WebSocket("ws://localhost:15000/myOceanProject");
    webSocket.onopen = onOpen;
    webSocket.onclose = onClose;
    webSocket.onmessage = onMessage;
}

let userNickName = document.getElementById("userId").innerText;
let userId = document.getElementById("userId").getAttribute("href");
let myGroupId;

// db에서 해당 그룹의 채팅 내용을 모두 가져온다.
function getList(param, callback, error) {
    $.ajax({
        url: "/chatting/groupId/" + param.groupId,
        type: "get",
        async:false,
        success: function (chattingDTOList, status, xhr) {
            if (callback) {
                callback(chattingDTOList);
            }
        },
        error: function (xhr, status, err) {
            if (error) {
                error(err);
            }
        }
    });

}


function getUnreadChat(error){
    console.log("getUnreadChat들어옴");
    $.ajax({
        url: "/chatting/unread",
        type: "get",
        success: function (groupDTOList,status, xhr) {
            console.log(groupDTOList);
            getUnreadStatus(groupDTOList);
        },
        error: function (xhr, status, err) {
            if (error) {
                error(err);
            }
        }
    });
}




// 채팅 db에서 해당 그룹의 채팅 내용을 모두 가져온 후 다시
function show(id) {
    getList({
        groupId: id
    }, getChattingContentList)
}

let temp = 0;
/* 왼쪽 대화목록에서 선택될 때마다 css 바꾸는 부분 */

$("#groupList").on("click","li",function (e) {
    e.preventDefault()
    console.log("채팅방 목록 클릭")
    myGroupId = $(this).attr("href");
    $("li.active").removeClass("select");
    $(this).addClass("select");
    console.log($(this))
    console.log($(this).find("#alarmSpace"))
    $(this).find("#alarmSpace").css("visibility", "hidden")
    show(myGroupId);
    connect();
})




// $("#sendButton").on("click", function(){
//     console.log(myGroupId);
//     console.log()
//     let chat = document.getElementById("msg").value;
//     // send();
//     // e.data = chat;
//     // webSocket.onmessage(e);
//     add({
//         chattingContent: chat,
//         groupId : myGroupId,
//         senderUserId : userId,
//         messageType : "대화"
//     })
// });
let chat
document.getElementById("sendButton").addEventListener("click",function(e){
    chat = document.getElementById("msg").value;

    // connect
    add({
        chattingContent: chat,
        groupId : myGroupId,
        senderUserId : userId,
        messageType : "대화"
    })
})

document.getElementById('msg').addEventListener('keydown',function(event){
    if (event.keyCode == 13) {
        event.preventDefault();
        document.getElementById('sendButton').click();
    }
})



function getUnreadStatus(groupDTOList){
    console.log("=================getUnreadStatus 들어옴===================")
    let realtext = ""
    groupDTOList.forEach(groupDTO => {
        // if (myGroupId == groupDTO.groupId) {
        //
        //     realtext += "<li class=\"active leftChattingList select\" href =" + groupDTO.groupId + ">"
        // }else{
            realtext += "<li class=\"active leftChattingList\" href =" + groupDTO.groupId + ">"
        // }
        realtext+= "<div class=\"thumb chatThumb\">"
        realtext+= "<img src=\"/imgin/chat/logo.png\" alt=\"chat_image\">"
        realtext+= "</div>"
        realtext+= "<div class=\"chatInfo\">"
        realtext+= "<div class=\"userIdAndBeforeTime\">"
        realtext+= "<div class=\"right\">"
        realtext+="<span class=\"userId\">"+groupDTO.groupName+"</span>"
        realtext+= "</div>"
        if(groupDTO.unreadMessage > 0) {
            realtext += "<div class=\"left\" id=\"alarmSpace\">"
            realtext += "<span>"
            realtext += "<img src=\"/imgin/chat/alertChatting.png\">"
            realtext += "</span>"
            realtext += "</div>"
            realtext+= "</div>"
            realtext+= "<p class=\"chatInfoTxt\"></p>"
            realtext+= "<p class=\"endTime\"></p>"
            realtext+= "</div>"
            realtext+= "</li>"
        }else{
            realtext+= "</div>"
            realtext+= "<p class=\"chatInfoTxt\"></p>"
            realtext+= "<p class=\"endTime\"></p>"
            realtext+= "</div>"
            realtext+= "</li>"
        }


    })
    $("#groupList").html(realtext);


}


function getChattingContentList(chattingDTOList) {
    let text = "";
    var time;
    chattingDTOList.forEach(chatting => {
        let userFileName = chatting.senderUserFileName;
        let userFilePath = chatting.senderUserFilePath;
        let userFileUuid = chatting.senderUserFileUuid;
        let imageSrc = "/mypage/display?fileName=" + userFilePath + "/" + userFileUuid + "_" + userFileName;
        console.log(imageSrc);
        if (chatting.chattingCreateDate !== time) {
            time = chatting.chattingCreateDate
            text += "<div class=\"dayInfo\">"
            text += "<p>" + chatting.chattingCreateDate + "</p>"
            text += "</div>"
            text += "<div class=\"opponent\">";
            text += "<div class=\"thumb\">"
            text += "<a href='javascript:void(0)' target=\"_blank\">"
            if (userFileUuid==null) {
                text += `<img src="/imgin/main/logo.png" alt="user thumbnail" class="Profile__Thumbnail-sc-1rgtq5h-8 eBTIQt">`
            } else {
                text += `<img src="` + imageSrc + `"alt="user thumbnail" class="Profile__Thumbnail-sc-1rgtq5h-8 eBTIQt">`
            }
            text += "</div>"
            text += "<div class=\"userIdChatTxt\">"
            text += "<span class=\"userId\">" + chatting.senderUserNickName + "</span>"
            text += "<div class=\"chatTxt\">"
            text += "<span class=\"chatTxtContents\">"
            text += "<a style=\"color: rgb(51, 51, 51);\">" + chatting.chattingContent + "</a>"
            text += "</span>"
            text += "<div class=\"timeWrap\">"
            text += "<span class=\"time\">" + chatting.chattingCreateTime + "</span>"
            text += "</div>"
            text += "</div>"
            text += "</div>"
            text += "</div>"
        } else {
            text += "<div class=\"opponent\">";
            text += "<div class=\"thumb\">"
            text += "<a href='javascript:void(0)' target=\"_blank\">"
            if (!userFileUuid) {
                text += `<img src="/imgin/main/logo.png" alt="user thumbnail" class="Profile__Thumbnail-sc-1rgtq5h-8 eBTIQt">`
            } else {
                text += `<img src="` + imageSrc + `"alt="user thumbnail" class="Profile__Thumbnail-sc-1rgtq5h-8 eBTIQt">`
            }
            text += "</div>"
            text += "<div class=\"userIdChatTxt\">"
            text += "<span class=\"userId\">" + chatting.senderUserNickName + "</span>"
            text += "<div class=\"chatTxt\">"
            text += "<span class=\"chatTxtContents\">"
            text += "<a style=\"color: rgb(51, 51, 51);\">" + chatting.chattingContent + "</a>"
            text += "</span>"
            text += "<div class=\"timeWrap\">"
            text += "<span class=\"time\">" + chatting.chattingCreateTime + "</span>"
            text += "</div>"
            text += "</div>"
            text += "</div>"
            text += "</div>"
        }

    })
    $(".chattingRoomWrap").html(text)
    document.getElementById('chattingRoom').scrollTop = document.getElementById('chattingRoom').scrollHeight;
}

function add(chatting, error){
    $.ajax({
        url: "/chatting/new",
        type: "post",
        data: JSON.stringify(chatting),
        contentType: "application/json; charset=utf-8",
        success: function (status, xhr) {
            send();
            document.getElementById("msg").value = '';
        },
        error: function(xhr, status, err){
            if(error){
                error(err);
            }
        }
    });
}

function disconnect(){
    webSocket.send(JSON.stringify({groupId : myGroupId, messageType:'퇴장',senderUserNickName:userNickName,senderUserId : userId}));
    webSocket.close();
}
function send(){
    let msg = document.getElementById("msg").value;
    webSocket.send(JSON.stringify({
        groupId : myGroupId,
        messageType:"대화",
        senderUserNickName:userNickName,
        senderUserId : userId,
        chattingContent : msg
    }))
    msg.value ='';
}
function onOpen(){
    webSocket.send(JSON.stringify({groupId : myGroupId, messageType:'입장',senderUserNickName:userNickName, senderUserId : userId}));
    console.log("onOpen 들어옴");
    console.log(myGroupId);
}
function onMessage(e){
    if(!e.data.includes(':')){
        return null;
    }
    console.log("onmessage들어옴")
    chattingRoom =document.getElementById("chattingRoom");
    chatdata = e.data;
    let datas = chatdata.replaceAll("\"", "");
    let realDatas = datas.split(":");
    let dateTime = new Date().toTimeString().split(' ')[0];
    let time = dateTime.split(":")


        chattingRoom.innerHTML =chattingRoom.innerHTML
        + "<div class=\"opponent\">"
        + "<div class=\"thumb\">"
        + "<a href='javascript:void(0)' target=\"_blank\">"
        + `<img src="`+realDatas[0]+`" alt="user thumbnail" class="Profile__Thumbnail-sc-1rgtq5h-8 eBTIQt">`
        + "</div>"
        + "<div class=\"userIdChatTxt\">"
        + "<span class=\"userId\">" + realDatas[1] + "</span>"
        + "<div class=\"chatTxt\">"
        + "<span class=\"chatTxtContents\">"
        + "<a style=\"color: rgb(51, 51, 51);\">" + realDatas[2] + "</a>"
        + "</span>"
        + "<div class=\"timeWrap\">"
        + "<span class=\"time\">" + time[0]+ ":" + time[1] + "</span>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "</div>"
    document.getElementById('chattingRoom').scrollTop = document.getElementById('chattingRoom').scrollHeight;
}
function onClose(){
    disconnect();
}

/* 오른쪽 하단 아이콘 누르면 채팅창 보이기 */
$(".chattingWrap2").on("click", function () {
    $(".chattingWrap2").css("display", "none");
    $("#chattingList").css("display", "block");
    getUnreadChat();
})

