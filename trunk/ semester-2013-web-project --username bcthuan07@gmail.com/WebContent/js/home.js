$(function(){
	
var $container = $('.right');
/* 	// initialize
	  $('.right').masonry({
	  columnWidth: 20,
	   itemSelector: '.a' 
	  
	});   */
	 
$('.right').masonry({
		columnWidth: 20,
		itemSelector: '.a',
		isFitWidth: false,

	})
.imagesLoaded(function() {
		$(this).masonry('reload');
	});
	
	
})