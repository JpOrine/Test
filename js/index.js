$("#top_nav").find("li").click(function(){
	$("#top_nav").find("li").removeClass("active");
	$(this).addClass("active");
	var i = $(this).index();
	$(".content").find("div").removeClass("active");
	$(".tab-pane").find("li").removeClass("action");
	$(".content").find("div").eq(i).addClass("active").find("li").eq(0).addClass("action");
	
})

$(".tab-pane").find("li").click(function(){
	$(".tab-pane").find("li").removeClass("action");
	$(this).addClass("action");
})