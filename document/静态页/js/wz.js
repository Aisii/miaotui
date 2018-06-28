$(function(){

			//点击底部输入框
			
		$(".pl_input").click(function(){
            $("body").append('<div class="mui-backdrop plcancle" onclick="CancelPl()"></div>');
            $(".pll_re").hide();
            $('.fix_pl').show();
            $('.pl_in').focus();
        })
			
			$(".pl_dz").click(function(){
				if($(this).attr("data-dz")=="false"){
					$(this).children("img").attr('src',"../images/dz_2.png");
					$(this).children("span").text(parseInt($(this).children("span").text())+1);
					$(this).attr("data-dz","true")
					
				}else{
					$(this).children("img").attr('src',"../images/dz_1.png");
					$(this).children("span").text(parseInt($(this).children("span").text())-1);
					$(this).attr("data-dz","false");
				}
			})
			mui('.mui-bar-tab').on('tap', 'a', function (e) { //底部导航切换切换
	            var href = this.getAttribute('href');
	            if (href != '') {
	                location.href = href;
	            }
	        });
	      
			//点赞
			var dz=parseInt($(".good_num").text());
			var good=0;//0为没有点赞，1为有点赞
			$(".good").click(function(){
				if(good==0)
				{
					//如果没有点赞
					$(this).children("img").prop("src",'../images/good_.png')
					dz++;
					$(".good_num").text(dz);
					good=1;
				}
				else
				{
					$(this).children("img").prop("src",'../images/dzz.png')
					dz--;
					$(".good_num").text(dz);
					good=0;
				}
			})
			
		

			
		
			//点击发表评论
			$(".pop").click(function(){
				if($('.pl_in').val()==""){
					mui.toast('评论为空',{ duration:'short', type:'div' }) 
				}else{
					$('.fix_pl').hide();
					$(".plcancle").remove();
					$(".pll_re").show();
					mui.toast('评论成功',{ duration:'long', type:'div' }) 
				}
			})
			//文章的点赞
			$(".dz_my").click(function(){
				var dz=parseInt($(".dz_num").text());
				if($(this).data("status")=="0"){
					console.log("000")
					dz++;
					$(".dz_num").text(dz);
					$(this).children(".sm_dz").attr("src","../images/dz_2.png");
					$(this).data("status","1")
				}else{
					console.log("000")
					dz--;
					$(".dz_num").text(dz);
					$(this).children(".sm_dz").attr("src","../images/dz_1.png");
					$(this).data("status","0")
				}
			})
		})
	
	//取消发表
	function CancelPl(){
		$(".fix_pl").hide();
		$(".pll_re").show();
		$(".plcancle").remove();
	}
	function fb_o(){
		$(".pop").css("color","#6699cc")
	}


// function OnPropChanged (event) {
//          if (event.propertyName.toLowerCase() == "value") {
//             console.log ("The new content: " + event.srcElement.value);
//          }
//      }