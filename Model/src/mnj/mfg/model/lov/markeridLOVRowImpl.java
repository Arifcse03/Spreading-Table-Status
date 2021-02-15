package mnj.mfg.model.lov;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Feb 01 16:41:03 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class markeridLOVRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        MarkerId {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getMarkerId();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setMarkerId((String)value);
            }
        }
        ,
        Yds {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getYds();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setYds((String)value);
            }
        }
        ,
        Inch {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getInch();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setInch((String)value);
            }
        }
        ,
        Meter {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getMeter();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setMeter((String)value);
            }
        }
        ,
        AdditionalLayLength {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getAdditionalLayLength();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setAdditionalLayLength((String)value);
            }
        }
        ,
        AdditionalYds {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getAdditionalYds();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setAdditionalYds((Number)value);
            }
        }
        ,
        AdditionalInches {
            public Object get(markeridLOVRowImpl obj) {
                return obj.getAdditionalInches();
            }

            public void put(markeridLOVRowImpl obj, Object value) {
                obj.setAdditionalInches((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(markeridLOVRowImpl object);

        public abstract void put(markeridLOVRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int MARKERID = AttributesEnum.MarkerId.index();
    public static final int YDS = AttributesEnum.Yds.index();
    public static final int INCH = AttributesEnum.Inch.index();
    public static final int METER = AttributesEnum.Meter.index();
    public static final int ADDITIONALLAYLENGTH = AttributesEnum.AdditionalLayLength.index();
    public static final int ADDITIONALYDS = AttributesEnum.AdditionalYds.index();
    public static final int ADDITIONALINCHES = AttributesEnum.AdditionalInches.index();

    /**
     * This is the default constructor (do not remove).
     */
    public markeridLOVRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute MarkerId.
     * @return the MarkerId
     */
    public String getMarkerId() {
        return (String) getAttributeInternal(MARKERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute MarkerId.
     * @param value value to set the  MarkerId
     */
    public void setMarkerId(String value) {
        setAttributeInternal(MARKERID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Yds.
     * @return the Yds
     */
    public String getYds() {
        return (String) getAttributeInternal(YDS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Yds.
     * @param value value to set the  Yds
     */
    public void setYds(String value) {
        setAttributeInternal(YDS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Inch.
     * @return the Inch
     */
    public String getInch() {
        return (String) getAttributeInternal(INCH);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Inch.
     * @param value value to set the  Inch
     */
    public void setInch(String value) {
        setAttributeInternal(INCH, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Meter.
     * @return the Meter
     */
    public String getMeter() {
        return (String) getAttributeInternal(METER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Meter.
     * @param value value to set the  Meter
     */
    public void setMeter(String value) {
        setAttributeInternal(METER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AdditionalLayLength.
     * @return the AdditionalLayLength
     */
    public String getAdditionalLayLength() {
        return (String) getAttributeInternal(ADDITIONALLAYLENGTH);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AdditionalLayLength.
     * @param value value to set the  AdditionalLayLength
     */
    public void setAdditionalLayLength(String value) {
        setAttributeInternal(ADDITIONALLAYLENGTH, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AdditionalYds.
     * @return the AdditionalYds
     */
    public Number getAdditionalYds() {
        return (Number) getAttributeInternal(ADDITIONALYDS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AdditionalYds.
     * @param value value to set the  AdditionalYds
     */
    public void setAdditionalYds(Number value) {
        setAttributeInternal(ADDITIONALYDS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute AdditionalInches.
     * @return the AdditionalInches
     */
    public Number getAdditionalInches() {
        return (Number) getAttributeInternal(ADDITIONALINCHES);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AdditionalInches.
     * @param value value to set the  AdditionalInches
     */
    public void setAdditionalInches(Number value) {
        setAttributeInternal(ADDITIONALINCHES, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
