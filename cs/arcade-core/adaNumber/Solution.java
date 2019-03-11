// https://app.codesignal.com/arcade/code-arcade/well-of-integration/Ghe6HWhFft8h6fR49

boolean adaNumber(String line) {
    
    line = line.toLowerCase();
    
    StringBuffer sb = new StringBuffer();
    int[] hashes = {-1,-1};
    
    for(int i = 0; i < line.length(); i++){
        char c = line.charAt(i);
        if(c == '_') continue;
        
        sb.append(c);
        if(c == '#') {
            if(hashes[0] == -1) hashes[0] = sb.length() - 1;
            else if (hashes[1] == -1) hashes[1] = sb.length() - 1;
            else return false;
        }
        else if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')){
            // all good?
        }
        else {
            return false;
        }
        
    }
    
    
    
    // check case for one hash
    if(hashes[0] != -1 && hashes[1] == -1){
        System.out.println("one hash.");
        return false;
    }
    
    // case for no hashes
    if(hashes[0] == -1){
        try {
            System.out.println("no hashes; regular base 10 number: \"" + sb.toString() + "\".");
            String s = sb.toString();
            if(s.length() == 0){
                System.out.println("false: empty string.");
                return false;
            }
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){ return false;}
    }
    
    // case for two hashes improperly placed
    if(hashes[0] == 0 || hashes[0] > 2) {
        System.out.println("bad hash.");
        return false;
    }
    if(hashes[1] != sb.length() - 1){
        System.out.println("second hash not at end.");
        return false;
    }
    if(hashes[1] - hashes[0] == 1) {
        System.out.println("hashes touching.");
        return false;
    }
    
    // case for two hashes placed correctly
    int base = Integer.parseInt(sb.toString().substring(0,hashes[0]));
    System.out.println("base: " + base);
    if(base < 2 || base > 16){
        System.out.println("invalid base: " + base + ".");
        return false;
    }

    String s = sb.toString().split("#")[1];
    System.out.println("number to parse: \"" + s + "\".");

    for(int i = 0; i < s.length(); i++){
        int v = 0;
        if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            v = s.charAt(i) - '0';
        }
        else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'f'){
            v = s.charAt(i) - 'a' + 10;
        }
        if(v >= base) return false;
    }


    
    return true;
}
