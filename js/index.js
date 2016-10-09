$("#top_nav").find("li").click(function(){
	$("#top_nav").find("li").removeClass("active");
	$(this).addClass("active");
})