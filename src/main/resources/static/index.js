/**
 * 
 */

    var form = document.getElementsByName("searchform")[0];
    var checkBox = document.getElementById("rideordrive");

    rideordrive.onchange = function(){
      if(this.checked){
        form.action = "/ridesearch";
      }else{
        form.action = "/driversearch";
      }
      console.log(form.action);
    };