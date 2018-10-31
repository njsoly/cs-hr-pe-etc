String simplifyPath(String path) {

    // start with root if not yet
    if(path.charAt(0) != '/'){
        path = "/" + path;
    }
    
    int i = 0;
    while(path.contains("//")){
        path = path.substring(0,path.indexOf("//")+1) + path.substring(path.indexOf("//")+2);

    }
    i = path.indexOf("/./");
    while(i != -1){
        path = path.substring(0,i) + "/" + path.substring(i+3);
        
        i = path.indexOf("/./");
    }
    
    i = path.indexOf("/..");
    while(i != -1){
        int up = i;
        while(--up >= 0){
            if(path.charAt(up) == '/'){
                break;
            }
        }
        if(up > 0){
            path = path.substring(0,up) + path.substring(i + 3);
        }
        else {
            path = path.substring(3);
        }
        
        
        i = path.indexOf("/..");
    }
   
    // remove leading dots 
    if(path.startsWith("../")){
        path = path.substring(2);
    }
    else if (path.startsWith("./")){
        path = path.substring(1);
    }
    
    // make sure it doesn't end in '/' unless that's all it is
    if(path.length() > 1 && path.endsWith("/")){
        path = path.substring(0,path.length() - 1);
    }
    
    
    return path;
}
