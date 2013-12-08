$(function(){
	
var $container = $('.right');
// initialize
	  $('.right').masonry({
	  columnWidth: 20,
	   itemSelector: '.a',
	   'isOrginLeft': true
	  
	})
	 
/*$('.right').masonry({
		columnWidth: 20,
		itemSelector: '.a',
		isFitWidth: false
		

	})*/
.imagesLoaded(function() {
		$(this).masonry('reload');
	});
	
	
});