package com.operations;


import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class WatcherService {
	
    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;
 
    public WatcherService(Path dir) throws IOException {
    	
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey, Path>();
 
        scanRegisterDirectories(dir);
    }
    
    private void registerDirectory(Path dir) throws IOException   {
    	   
	WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        keys.put(key, dir);
    }
    
    private void scanRegisterDirectories(final Path start) throws IOException {
      
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            	registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    
   public void processEvents() {
        while(true) {

            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
 
            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }
 
            for (WatchEvent<?> event : key.pollEvents()) {
                @SuppressWarnings("rawtypes")
                WatchEvent.Kind kind = event.kind();
 
                
                @SuppressWarnings("unchecked")
                Path name = ((WatchEvent<Path>)event).context();
                Path child = dir.resolve(name);
 
                System.out.format("%s: %s\n", event.kind().name(), child);
 
              
                if (kind == ENTRY_CREATE) {
                	System.out.println("My source file has created!!!");
					
                }
                
                if (kind == ENTRY_MODIFY  ) {
                    System.out.println("My source file has changed!!!");
                }
                
                if (kind == ENTRY_DELETE  ) {
                    System.out.println("My source file has Deleted!!!");
                }
            }
 
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);
 
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {

 	   Path path = Paths.get("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/ClassPractice/file-watch/Demo");
 	   Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
 	   new WatcherService(path).processEvents();
 	   
    }
}



