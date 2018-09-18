/**
 * 
 */

$('#myForm input').on('change', function() {
   alert($('input[type="radio"]:checked', '#myForm').val()); 
});
