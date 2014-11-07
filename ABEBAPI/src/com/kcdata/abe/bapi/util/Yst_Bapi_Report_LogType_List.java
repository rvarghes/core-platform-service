package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Report_LogType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -403723819L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_REPORT_LOG", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Report_LogType.class, new com.kcdata.abe.bapi.Yst_Bapi_Report_LogType(), new java.lang.String[][]{}, 425, 850, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_REPORT_LOG\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Report Log data</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>425</ifr:internalLength1><ifr:internalLength2>850</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Report_LogType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsAllYst_Bapi_Report_LogType(Yst_Bapi_Report_LogType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType removeYst_Bapi_Report_LogType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Report_LogType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType getYst_Bapi_Report_LogType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Report_LogType)baseList().get(index);
    }

    public Yst_Bapi_Report_LogType_List subListYst_Bapi_Report_LogType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Report_LogType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsYst_Bapi_Report_LogType(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        return baseList().contains(item);
    }

    public void addAllYst_Bapi_Report_LogType(Yst_Bapi_Report_LogType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[] toArrayYst_Bapi_Report_LogType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[] {});
    }

    public void addAllYst_Bapi_Report_LogType(int index, Yst_Bapi_Report_LogType_List item) {
        baseList().addAll(index, item);
    }

    public void addYst_Bapi_Report_LogType(int index, com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        baseList().add(index, item);
    }

    public int lastIndexOfYst_Bapi_Report_LogType(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        return baseList().lastIndexOf(item);
    }

    public void addYst_Bapi_Report_LogType(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        baseList().add(item);
    }

    public int indexOfYst_Bapi_Report_LogType(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYst_Bapi_Report_LogType(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType setYst_Bapi_Report_LogType(int index, com.kcdata.abe.bapi.Yst_Bapi_Report_LogType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Report_LogType)baseList().set(index, item);
    }

}
