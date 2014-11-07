package com.kcdata.abe.bapi.util;
public class Yst_Bapi_CommentsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2027889360L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_COMMENTS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_CommentsType.class, new com.kcdata.abe.bapi.Yst_Bapi_CommentsType(), new java.lang.String[][]{}, 290, 574, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_COMMENTS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Comments</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>290</ifr:internalLength1><ifr:internalLength2>574</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_CommentsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsYst_Bapi_CommentsType(com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        return baseList().contains(item);
    }

    public void addYst_Bapi_CommentsType(com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CommentsType getYst_Bapi_CommentsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CommentsType)baseList().get(index);
    }

    public boolean removeYst_Bapi_CommentsType(com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_CommentsType(Yst_Bapi_CommentsType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllYst_Bapi_CommentsType(Yst_Bapi_CommentsType_List item) {
        baseList().addAll(item);
    }

    public void addYst_Bapi_CommentsType(int index, com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        baseList().add(index, item);
    }

    public int indexOfYst_Bapi_CommentsType(com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        return baseList().indexOf(item);
    }

    public int lastIndexOfYst_Bapi_CommentsType(com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CommentsType setYst_Bapi_CommentsType(int index, com.kcdata.abe.bapi.Yst_Bapi_CommentsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CommentsType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CommentsType removeYst_Bapi_CommentsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_CommentsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CommentsType[] toArrayYst_Bapi_CommentsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_CommentsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_CommentsType[] {});
    }

    public Yst_Bapi_CommentsType_List subListYst_Bapi_CommentsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_CommentsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Bapi_CommentsType(int index, Yst_Bapi_CommentsType_List item) {
        baseList().addAll(index, item);
    }

}
