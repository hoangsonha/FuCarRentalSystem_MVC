
function Oamuser_Js_getRowSelected() {
	
	$index = document.querySelector('input[name=Oamuser_InGroup_1]:checked').value;
	
	$row = Global_JS_GetRowSelected("Oamuser_Table_1",$index);
	
	document.getElementById("input1").value = $row.cells[1].innerHTML;
	document.getElementById("input2").value = $row.cells[2].innerHTML;
	document.getElementById("input3").value = $row.cells[3].innerHTML;
	document.getElementById("input4").value = $row.cells[4].innerHTML;
	document.getElementById("input5").value = $row.cells[5].innerHTML;
	document.getElementById("input6").value = $row.cells[6].innerHTML;
	document.getElementById("input7").value = $row.cells[7].innerHTML;
	document.getElementById("input8").value = $row.cells[8].innerHTML;
	document.getElementById("input9").value = $row.cells[9].innerHTML;
	document.getElementById("input10").value = $row.cells[10].innerHTML;

}
 