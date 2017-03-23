$(document).ready(function() {
    $('#list').click(function(event){
    	event.preventDefault();
    	$('#products .item').addClass('list-group-item');
    });
    
    $('#grid').click(function(event){
    	event.preventDefault();
    	$('#products .item').removeClass('list-group-item');
    });
});

function showPassword() {
    var password_attr = $('#password').attr('type');
    if(password_attr != 'text') {
        $('.checkbox').addClass('show');
        $('#password').attr('type', 'text');
    } else {
        $('.checkbox').removeClass('show');
        $('#password').attr('type', 'password');
   }
}