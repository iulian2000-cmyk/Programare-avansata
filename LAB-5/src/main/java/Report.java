import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;
import java.util.List;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

class Report extends Command
{
   Report(Catalog catalog) throws Exception
   {
       this.setName("report");
       this.setCatalog(catalog);
       LinkedList<String > args = new LinkedList<>();
       args.add(catalog.getName());
       this.setArguments(args);
       try{
           this.validateCommand();
       }catch (InvalidCommand a){
           System.out.println("Invalid command");
       }
       this.createReport();
   }

    /**
     * Metoda care creaza raportul HTML .
     * LINK : https://www.viralpatel.net/freemaker-template-hello-world-tutorial/
     * @return void
     * @throws Exception
     */
   public void createReport() throws Exception
   {
       //Load template from source folder
       Configuration cfg = new Configuration();
       Template template = cfg.getTemplate("/src/main/java/templates/helloworld.ftl");

       // Build the data-model
       Map<String, Object> data = new HashMap<String, Object>();
       data.put("title", this.getCatalog().getName());

       List<String> items_name = new ArrayList<String>();
       Vector<Item> items = getCatalog().getItems();


       for(int index=0;index < this.getCatalog().getItems().size();index++)
       {
            items_name.add(items.get(index).getName());
       }

       data.put("items",items_name);
       // Console output
       Writer out = new OutputStreamWriter(System.out);
       template.process(data, out);
       out.flush();

       // File output
       Writer file = new FileWriter (new File("reportCatalog.html"));
       template.process(data, file);
       file.flush();
       file.close();
   }
}
