function verboseRevString(s){
	if(typeof s == "undefined"){
		s = 'snth';
    }
    for(i = 0; i < s.length; i++){
        c = s[i];
        c = String.fromCharCode(
            'z'.charCodeAt(0) - c.charCodeAt(0)
             + 'a'.charCodeAt(0)
        );
        console.log("s[" + i + "] is " + s[i] + " -> " + c + ".");
	
    }
}