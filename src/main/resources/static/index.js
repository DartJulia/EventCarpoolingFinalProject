/**
 * 
 */

    var form = document.getElementsByName("searchform")[0];
    var checkBox = document.getElementById("rideordrive");

    rideordrive.onchange = function(){
      if(this.checked){
        form.action = "/allsearch";
      }else{
        form.action = "/ridesearch";
      }
      console.log(form.action);
    };