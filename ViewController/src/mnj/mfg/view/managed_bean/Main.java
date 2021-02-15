package mnj.mfg.view.managed_bean;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.lang.Double;

import java.util.Hashtable;

import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Row;
import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class Main {
    private RichInputText yds;
    private RichInputText inch;
    private RichInputText meter;
    private RichInputText additionalLayLength;
    private RichTable markeridTable;
    private RichInputListOfValues planNumber;
    private RichInputText actualYds;
    private RichInputText actualInch;
    private RichInputText actualMeter;
    private RichInputDate startTime;
    private RichInputDate endTime;
    private RichInputText timeCal;
    private RichInputText newInch;
    private RichInputText newYards;

    public Main() {
        super();
    }

    public void setYds(RichInputText yds) {
        this.yds = yds;
    }

    public RichInputText getYds() {
        return yds;
    }

    public void setInch(RichInputText inch) {
        this.inch = inch;
    }

    public RichInputText getInch() {
        return inch;
    }

    public void setMeter(RichInputText meter) {
        this.meter = meter;
    }

    public RichInputText getMeter() {
        return meter;
    }

    public void setAdditionalLayLength(RichInputText additionalLayLength) {
        this.additionalLayLength = additionalLayLength;
    }

    public RichInputText getAdditionalLayLength() {
        return additionalLayLength;
    }

//    public void valueChanger(ValueChangeEvent valueChangeEvent) {
//            System.out.println("valueChanger --->");
//            System.out.println("after value changer --->"+valueChangeEvent.getNewValue());
//        // Add event code here...
//        double aa = Double.parseDouble(valueChangeEvent.getNewValue().toString());
//            System.out.println("valueChanger 2 --->");
   //     double bb = Double.parseDouble(getLineValue("PlanYds"));
//        double cc = Double.parseDouble(getLineValue("PlanInch"));
//        double ff = 0.0,gg = 0.0;
//            System.out.println("valueChanger 3 --->");
//        
//        ff = aa + cc ;  
//            System.out.println("inch --->"+ff);
//       gg = bb + cc ;
//            System.out.println("func area --->"+gg);
//            setElcTbleTotVal(ff,gg);
//        yds.setValue(ff);   
//         AdfFacesContext.getCurrentInstance().addPartialTarget(yds);
//         
//            inch.setValue(gg);   
//             AdfFacesContext.getCurrentInstance().addPartialTarget(inch);
//             
//        
//         System.out.println("inch --->"+ff);
//        
//         System.out.println("func area --->"+gg);
// 
//        }
     
       public void setElcTbleTotVal(double val, double gg) {

              oracle.adf.view.rich.component.UIXTable table = getMarkeridTable();
              // Get the Selected Row key set iterator
              java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
              double ply = 0.0;
              while (selectionIt.hasNext()) {
                  Object rowKey = selectionIt.next();
                  table.setRowKey(rowKey);
                  int index = table.getRowIndex();
                  FacesCtrlHierNodeBinding row =
                      (FacesCtrlHierNodeBinding)table.getRowData(index);
                  Row selectedRow = row.getRow();
                   selectedRow.setAttribute("PlanYds",val);
                  selectedRow.setAttribute("PlanInch",val);
                 

              }
              
       }
       
    public String getLineValue(String columnName) {

           oracle.adf.view.rich.component.UIXTable table = getMarkeridTable();
           // Get the Selected Row key set iterator
           java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
           double ply = 0.0;
        String val=null;
           while (selectionIt.hasNext()) {
               Object rowKey = selectionIt.next();
               table.setRowKey(rowKey);
               int index = table.getRowIndex();
               FacesCtrlHierNodeBinding row =
                   (FacesCtrlHierNodeBinding)table.getRowData(index);
               Row selectedRow = row.getRow();
            
               
               
               try {
                
               val= selectedRow.getAttribute(columnName).toString();
            } catch (Exception e) {
               ;                 

           }
           }
        
    return val;
    }
    
    public void setMarkeridTable(RichTable markeridTable) {
        this.markeridTable = markeridTable;
    }

    public RichTable getMarkeridTable() {
        return markeridTable;
    }
    
    public long printDate(String date, String seconddate) {

         //  DateFormat df = new SimpleDateFormat("hh:mm:ss");
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            java.util.Date date1       = new java.util.Date();
            java.util.Date seconddate1 = new java.util.Date();
            //java.util.Date resultdate  = new java.util.Date();
            //String resultdate;
            long resultdate= -1;

            try {
                date1 = df.parse(date);
                seconddate1 = df.parse(seconddate);
                
                resultdate = date1.getTime() - seconddate1.getTime();
                
                
            } catch (Exception e) {
                ;
            }

            return resultdate;
    }

    public void setPlanNumber(RichInputListOfValues planNumber) {
        this.planNumber = planNumber;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("planNumber", planNumber.getValue());
        System.out.println("Session style-->"+planNumber.getValue());
    }

    public RichInputListOfValues getPlanNumber() {
        return planNumber;
    }

    public void setActualYds(RichInputText actualYds) {
        this.actualYds = actualYds;
    }

    public RichInputText getActualYds() {
        return actualYds;
    }

    public void setActualInch(RichInputText actualInch) {
        this.actualInch = actualInch;
    }

    public RichInputText getActualInch() {
        return actualInch;
    }

    public void setActualMeter(RichInputText actualMeter) {
        this.actualMeter = actualMeter;
    }

    public RichInputText getActualMeter() {
        return actualMeter;
    }
    
    
//    public void valueChangerlistner(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        double AdditionalLayLength = Double.parseDouble((getAdditionalLayLength().getValue().toString()));
//        double ActualYds = Double.parseDouble((getActualYds().getValue().toString()));
//        double ActualInch = Double.parseDouble((getActualInch().getValue().toString()));
//        double ActualMeter = Double.parseDouble((getActualMeter().getValue().toString()));
//        double Yds = Double.parseDouble((getYds().getValue().toString()));
//        double Inch = Double.parseDouble((getInch().getValue().toString()));
//        double Meter = Double.parseDouble((getMeter().getValue().toString()));
//        double newinches = Double.parseDouble((getNewInch().getValue().toString()));
//        
//        double ff = 0.0,gg = 0.0, ee = 0.0, newinch=0.0 ;
//        ff = (AdditionalLayLength + Yds);
//        gg = (AdditionalLayLength + Inch);
//        ee = (AdditionalLayLength + Meter);
//       // newinch = (AdditionalLayLength + newinches);
//
//        actualYds.setValue(ff);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(actualYds);
//        
//        
//        yds.setValue(ff);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(yds);
//        
//        inch.setValue(newinch);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(inch);
//        
////        newInch.setValue(newinch);
////        AdfFacesContext.getCurrentInstance().addPartialTarget(newInch);
//        
//        meter.setValue(ee);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(meter);
//        
//        
//        System.out.println("actualYds --->"+ff);
//        System.out.println("yds --->"+ff);
//        System.out.println("after plus --->"+newinch);
////        System.out.println("func area --->"+gg);
////        System.out.println("marker effi ---------->"+dd);    
//    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public String comment() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
  
  
//    public String calculation() {
//       Hashtable table =  getValue();
//         System.out.println("enter calculation --->");        
//             double total1= (Double)table.get("tot1");
//        System.out.println("on cal inches --->"+total1);
////         double total2= (Double)table.get("tot2");
////        double total3= (Double)table.get("tot3");
////       // double total4= (Double)table.get("tot4");
//       setValue(total1);
////        
//        AdfFacesContext.getCurrentInstance().addPartialTarget(inch);
////        AdfFacesContext.getCurrentInstance().addPartialTarget(actualMeter);
////         AdfFacesContext.getCurrentInstance().addPartialTarget(yds);
//           AdfFacesContext.getCurrentInstance().addPartialTarget(newInch);
////        AdfFacesContext.getCurrentInstance().addPartialTarget(meter);
////       // AdfFacesContext.getCurrentInstance().addPartialTarget(newInch);
////        // Add event code here...
//        return null;
//    }
    
//    public Hashtable getValue() {
//        
//        Hashtable ht = new Hashtable ();
//        
//        BindingContext bindingContext = BindingContext.getCurrent();
//        DCDataControl dc =bindingContext.findDataControl("MainAMDataControl"); //
//        ApplicationModule am = dc.getApplicationModule();
//        ViewObject findViewObject =am.findViewObject("LinesVO1");//ImpSaleContractDetailEOView1
//        
//        RowSetIterator it = findViewObject.createRowSetIterator("tt");
//        double val = 0.0, total = 0.0 ,gtotal = 0.0;
//        double val1 = 0.0, total1 =0.0, gtotal1 = 0.0 ;
//        double val11 = 0.0, total11 =0.0, gtotal11 = 0.0 ;
//       //double val111 = 0.0, total111 =0.0, gtotal111 = 0.0 ;
//      
//      // while (it.hasNext()){
//
////                Row r = it.next();
//                Row r = findViewObject.getCurrentRow();
//                
//                try {
//                        val = Double.parseDouble(r.getAttribute("PlanYds").toString());
//                    val1 = Double.parseDouble(r.getAttribute("PlanInch").toString());
//                    val11 = Double.parseDouble(r.getAttribute("PlanMeter").toString());
//                  // val111 = Double.parseDouble(r.getAttribute("Inches").toString());
//                }
//                catch (Exception e ){val = 0.0;}
//            
//            
//            try {
//                total =
//                        Double.parseDouble(getAdditionalLayLength().getValue().toString());
//                total1 =
//                        Double.parseDouble(getAdditionalLayLength().getValue().toString());
//                total11 =
//                        Double.parseDouble(getAdditionalLayLength().getValue().toString());
////              total111 =
////                        Double.parseDouble(getAdditionalLayLength().getValue().toString());
//            } 
//            catch (Exception nfe) {
//                // TODO: Add catch code
//                nfe.printStackTrace();
//                total = 0.0;
//               total1 = 0.0;
//                total11 = 0.0;
//               // total111 = 0.0;
//            }
//             gtotal = val+total;
//             gtotal1 = val1+total;
//            gtotal11 = val11+total1;
//      //  gtotal111 = val111+total11;
//            
//        double yards = 0.0 ;
//    
////        if (gtotal1 >= 36) {
////            
////          yards =  gtotal1/36;
////          
////         System.out.println("if inches > equal to --->"+gtotal1);
////            System.out.println("if inches > equal to --->"+yards);
////            
////        }
//            r.setAttribute("ActualYds",gtotal);
//            r.setAttribute("PlanYds",gtotal);
//            r.setAttribute("PlanInch",gtotal1);
//            r.setAttribute("PlanMeter",gtotal11);
//            r.setAttribute("ActualInch",gtotal1);
//            r.setAttribute("ActualMeter",gtotal11);
//           // r.setAttribute("Inches",gtotal111);
//            
//     //   } //end of while loop
//        
//        ht.put("tot1", gtotal);
//        ht.put("tot2", gtotal1);
//        ht.put("tot3", gtotal11);
//       // ht.put("tot4", gtotal111);
//        
//        it.closeRowSetIterator();
//        return ht;
//        
//     
//    } 
    
//    public void setValue(double val,double val1,double val11 ) 
//    
//    {
//       oracle.adf.view.rich.component.UIXTable table = getMarkeridTable();
//        // Get the Selected Row key set iterator
//        java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
//        double ply = 0.0;
//        while (selectionIt.hasNext()) 
//        {
//            Object rowKey = selectionIt.next();
//            table.setRowKey(rowKey);
//            int index = table.getRowIndex();
//            FacesCtrlHierNodeBinding row =
//                (FacesCtrlHierNodeBinding)table.getRowData(index);
//            Row selectedRow = row.getRow();
//            selectedRow.setAttribute("ActualYds",val);
//            selectedRow.setAttribute("PlanYds",val);
//            selectedRow.setAttribute("PlanInch",val1);
//            selectedRow.setAttribute("PlanMeter",val11);
//            selectedRow.setAttribute("ActualInch",val1);
//            selectedRow.setAttribute("ActualMeter",val11);
//            //selectedRow.setAttribute("Inches",val111);
//        }        
//    }
    ///////////////////////// new code ///////////
    
    
    public String calculation() {
       Hashtable table =  getValue();
       
         System.out.println("enter calculation --->");        
            // int total1= (Integer)table.get("tot1");
            int total1= (Integer)table.get("tot2");
        System.out.println("on cal inches --->"+total1);
        double val1= (Double)table.get("tot1");
      
        System.out.println("on cal yards --->"+val1);
        
       setValue(total1,val1);

        AdfFacesContext.getCurrentInstance().addPartialTarget(inch);
           AdfFacesContext.getCurrentInstance().addPartialTarget(newInch);
        AdfFacesContext.getCurrentInstance().addPartialTarget(yds);
        AdfFacesContext.getCurrentInstance().addPartialTarget(actualYds);
        AdfFacesContext.getCurrentInstance().addPartialTarget(actualInch);
        return null;
    }
    
       public Hashtable getValue() {
       Hashtable ht = new Hashtable ();
        BindingContext bindingContext = BindingContext.getCurrent();
    DCDataControl dc =bindingContext.findDataControl("MainAMDataControl"); //
    ApplicationModule am = dc.getApplicationModule();
    ViewObject findViewObject =am.findViewObject("LinesVO1");//ImpSaleContractDetailEOView1
    RowSetIterator it = findViewObject.createRowSetIterator("tt");
          double val = 0.0, total = 0.0 ,gtotal = 0.0; 
            double val1 = 0.0;
            double val1l = 0.0;
          // while (it.hasNext())
          // {
    
      // Row r = it.next();
                  Row r = findViewObject.getCurrentRow();
                    
                   try {
                            val = Double.parseDouble(r.getAttribute("Inches").toString());
                       
                       System.out.println("inches new field --->"+val);
                      val1 = Double.parseDouble(r.getAttribute("PlanYds").toString());
                       val1l = Double.parseDouble(r.getAttribute("Yards").toString());
                    
                       System.out.println("plan yards new field --->"+val1);
                  
                   }
                  catch (Exception e ){val = 0.0;}
                
    
    try {
                  total =
                         Double.parseDouble(getAdditionalLayLength().getValue().toString());
                    
                    System.out.println("additional lay length --->"+total);
   
                } 
              catch (Exception nfe) {
     //TODO: Add catch code
                   nfe.printStackTrace();
                    total = 0.0;
                }
                 gtotal = val+total;
            System.out.println("additional lay length plus new inches --->"+gtotal);
                 
            //if (gtotal >= 36)
            
                val1 = gtotal/36 ;
            
            System.out.println("yards after division --->"+val1);   
            
            int d = (int)val1;
            System.out.println("Decimal --->"+d);
            
        
            double f = val1-d ;
            System.out.println("fractions --->"+f);  
            
            f = f*36;
            
            int dd = (int)val1l+d;
            System.out.println("Decimal+yards --->"+dd);
                
            if (f < 1)
                f = f*36;
                
            r.setAttribute("PlanYds",dd);//val1);
            r.setAttribute("PlanInch",f);//gtotal);
           
        
                
            ht.put("tot1", f);//gtotal);
            ht.put("tot2", dd);//val1);
           it.closeRowSetIterator();
      
        return ht;
  
        }
           
        
        public void setValue(double val, double val1 ) 
       
        {
           oracle.adf.view.rich.component.UIXTable table = getMarkeridTable();
            // Get the Selected Row key set iterator
            java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
            double ply = 0.0,ActualMeter = 0.0,ActualMeterCalc = 0.0 , ResultMeter = 0.0;
            while (selectionIt.hasNext()) 
          
            {
                Object rowKey = selectionIt.next();
                table.setRowKey(rowKey);
                int index = table.getRowIndex();
                FacesCtrlHierNodeBinding row =
                    (FacesCtrlHierNodeBinding)table.getRowData(index);
                Row selectedRow = row.getRow();
                selectedRow.setAttribute("PlanInch",val1);//Math.round(val1));
                selectedRow.setAttribute("PlanYds",val);
                selectedRow.setAttribute("ActualInch",val1);//Math.round(val1));
                selectedRow.setAttribute("ActualYds",val);
                
                ActualMeter     = val * 0.9144;
                ActualMeterCalc = val1 * 0.0254;
                ResultMeter     = ActualMeter + ActualMeterCalc; 
                
                selectedRow.setAttribute("ActualMeter",ResultMeter);
                selectedRow.setAttribute("PlanMeter",ResultMeter);
                
                
                
            }        
        }
    
    
    
    /////////////////////////////////////////////
    


    public void setStartTime(RichInputDate startTime) {
        this.startTime = startTime;
    }

    public RichInputDate getStartTime() {
        return startTime;
    }

    public void setEndTime(RichInputDate endTime) {
        this.endTime = endTime;
    }

    public RichInputDate getEndTime() {
         
        return endTime ;
    }

    public void setTimeCal(RichInputText timeCal) {
        this.timeCal = timeCal;
    }

    public RichInputText getTimeCal() {
        return timeCal;
    }
    
    
//    public long getDateDiff( RichInputDate   EndTime, RichInputDate  StartTime, TimeUnit tu )
//    {
//    
//    long D = EndTime- StartTime;
//    return tu.convert(D, TimeUnit.MILLISECONDS);
//    
//    }
    
    public void valueChangerDate(ValueChangeEvent valueChangeEvent) {
        
        long TimeCalculation = 0;
        if(getEndTime().getValue()!= null && getStartTime().getValue()!= null)
        
        {
        TimeCalculation =printDate(getEndTime().getValue().toString(),getStartTime().getValue().toString());
        
        TimeCalculation = TimeCalculation / 60000;
        // TimeCalculation = TimeCalculation / 1000;   Seconds 
        // TimeCalculation = TimeCalculation / 60;   Minutes
    
       timeCal.setValue(TimeCalculation);
        AdfFacesContext.getCurrentInstance().addPartialTarget(timeCal);
        System.out.println("timeCal --->"+TimeCalculation);
        }
        else {
            timeCal.setValue(0);
             AdfFacesContext.getCurrentInstance().addPartialTarget(timeCal);
            
        }
    }

    public void setNewInch(RichInputText newInch) {
        this.newInch = newInch;
    }

    public RichInputText getNewInch() {
        return newInch;
    }

    public void setNewYards(RichInputText newYards) {
        this.newYards = newYards;
    }

    public RichInputText getNewYards() {
        return newYards;
    }


    public void ActualFieldsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        double ActualYds,ActualInch,ActualMeter,ActualMeter1,MeterResult;
        
        try 
        {
            ActualYds = Double.parseDouble(getActualYds().getValue().toString());
            System.out.println("ActualYds........ "+ActualYds);
        } catch (Exception e) 
        {
            // TODO: Add catch code
            ActualYds = 0.0;  
        }
        try 
        {
            ActualInch = Double.parseDouble(getActualInch().getValue().toString());  
            System.out.println("ActualInch...... "+ActualInch);
            
            if (ActualInch > 35 )
            {
                
                   /* Message Printing */
                   
                   FacesContext context = FacesContext.getCurrentInstance();          
                   FacesMessage message = new FacesMessage("Inches Can Not Exceed 35");          
                   context.addMessage(null, message);
                   ActualInch = 0.0;
                   actualInch.setValue(ActualInch);
                   
                   /* End Message */ 
               }
            
            
        } catch (Exception e) 
        {
            // TODO: Add catch code
            ActualInch = 0.0;      
        }
        try 
        {
            ActualMeter  = ActualYds  * 0.9144;   
            ActualMeter1 = ActualInch * 0.0254;
            MeterResult  = ActualMeter + ActualMeter1;
            
            System.out.println("MeterResult....... "+MeterResult);
            
            actualMeter.setValue(MeterResult);
            
        } catch (Exception e) 
        {
            // TODO: Add catch code
            ActualMeter = 0.0;    
        }
        
        
    }
}


