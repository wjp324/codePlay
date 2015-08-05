$(document).ready(function(){
/*	$(document).on("click",".item a",function(e){
		e.preventDefault();
		$("#showDetail").show();
		$("#detail img").attr("src",$(this).find("img").attr("src"));
		$("#detail p").text($(this).find("p").text());
	});
	$("#showDetail").click(function(){
		$("#showDetail").hide();
	});
*/
    var $container = $('.container');

    $container.imagesLoaded(function() {
        $container.masonry({
            itemSelector: '.item'
        });
    });
});