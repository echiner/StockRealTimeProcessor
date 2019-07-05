/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.gft.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Contract extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6712383617026375967L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Contract\",\"namespace\":\"com.gft.model\",\"fields\":[{\"name\":\"ContractId\",\"type\":\"int\"},{\"name\":\"Version\",\"type\":\"int\"},{\"name\":\"fraRate\",\"type\":\"double\"},{\"name\":\"referenceRate\",\"type\":\"double\"},{\"name\":\"notionalPrincipal\",\"type\":\"double\"},{\"name\":\"valid\",\"type\":\"boolean\"},{\"name\":\"validationResults\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Contract> ENCODER =
      new BinaryMessageEncoder<Contract>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Contract> DECODER =
      new BinaryMessageDecoder<Contract>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Contract> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Contract> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Contract>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Contract to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Contract from a ByteBuffer. */
  public static Contract fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int ContractId;
  @Deprecated public int Version;
  @Deprecated public double fraRate;
  @Deprecated public double referenceRate;
  @Deprecated public double notionalPrincipal;
  @Deprecated public boolean valid;
  @Deprecated public java.util.List<java.lang.CharSequence> validationResults;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Contract() {}

  /**
   * All-args constructor.
   * @param ContractId The new value for ContractId
   * @param Version The new value for Version
   * @param fraRate The new value for fraRate
   * @param referenceRate The new value for referenceRate
   * @param notionalPrincipal The new value for notionalPrincipal
   * @param valid The new value for valid
   * @param validationResults The new value for validationResults
   */
  public Contract(java.lang.Integer ContractId, java.lang.Integer Version, java.lang.Double fraRate, java.lang.Double referenceRate, java.lang.Double notionalPrincipal, java.lang.Boolean valid, java.util.List<java.lang.CharSequence> validationResults) {
    this.ContractId = ContractId;
    this.Version = Version;
    this.fraRate = fraRate;
    this.referenceRate = referenceRate;
    this.notionalPrincipal = notionalPrincipal;
    this.valid = valid;
    this.validationResults = validationResults;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ContractId;
    case 1: return Version;
    case 2: return fraRate;
    case 3: return referenceRate;
    case 4: return notionalPrincipal;
    case 5: return valid;
    case 6: return validationResults;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ContractId = (java.lang.Integer)value$; break;
    case 1: Version = (java.lang.Integer)value$; break;
    case 2: fraRate = (java.lang.Double)value$; break;
    case 3: referenceRate = (java.lang.Double)value$; break;
    case 4: notionalPrincipal = (java.lang.Double)value$; break;
    case 5: valid = (java.lang.Boolean)value$; break;
    case 6: validationResults = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ContractId' field.
   * @return The value of the 'ContractId' field.
   */
  public java.lang.Integer getContractId() {
    return ContractId;
  }

  /**
   * Sets the value of the 'ContractId' field.
   * @param value the value to set.
   */
  public void setContractId(java.lang.Integer value) {
    this.ContractId = value;
  }

  /**
   * Gets the value of the 'Version' field.
   * @return The value of the 'Version' field.
   */
  public java.lang.Integer getVersion() {
    return Version;
  }

  /**
   * Sets the value of the 'Version' field.
   * @param value the value to set.
   */
  public void setVersion(java.lang.Integer value) {
    this.Version = value;
  }

  /**
   * Gets the value of the 'fraRate' field.
   * @return The value of the 'fraRate' field.
   */
  public java.lang.Double getFraRate() {
    return fraRate;
  }

  /**
   * Sets the value of the 'fraRate' field.
   * @param value the value to set.
   */
  public void setFraRate(java.lang.Double value) {
    this.fraRate = value;
  }

  /**
   * Gets the value of the 'referenceRate' field.
   * @return The value of the 'referenceRate' field.
   */
  public java.lang.Double getReferenceRate() {
    return referenceRate;
  }

  /**
   * Sets the value of the 'referenceRate' field.
   * @param value the value to set.
   */
  public void setReferenceRate(java.lang.Double value) {
    this.referenceRate = value;
  }

  /**
   * Gets the value of the 'notionalPrincipal' field.
   * @return The value of the 'notionalPrincipal' field.
   */
  public java.lang.Double getNotionalPrincipal() {
    return notionalPrincipal;
  }

  /**
   * Sets the value of the 'notionalPrincipal' field.
   * @param value the value to set.
   */
  public void setNotionalPrincipal(java.lang.Double value) {
    this.notionalPrincipal = value;
  }

  /**
   * Gets the value of the 'valid' field.
   * @return The value of the 'valid' field.
   */
  public java.lang.Boolean getValid() {
    return valid;
  }

  /**
   * Sets the value of the 'valid' field.
   * @param value the value to set.
   */
  public void setValid(java.lang.Boolean value) {
    this.valid = value;
  }

  /**
   * Gets the value of the 'validationResults' field.
   * @return The value of the 'validationResults' field.
   */
  public java.util.List<java.lang.CharSequence> getValidationResults() {
    return validationResults;
  }

  /**
   * Sets the value of the 'validationResults' field.
   * @param value the value to set.
   */
  public void setValidationResults(java.util.List<java.lang.CharSequence> value) {
    this.validationResults = value;
  }

  /**
   * Creates a new Contract RecordBuilder.
   * @return A new Contract RecordBuilder
   */
  public static com.gft.model.Contract.Builder newBuilder() {
    return new com.gft.model.Contract.Builder();
  }

  /**
   * Creates a new Contract RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Contract RecordBuilder
   */
  public static com.gft.model.Contract.Builder newBuilder(com.gft.model.Contract.Builder other) {
    return new com.gft.model.Contract.Builder(other);
  }

  /**
   * Creates a new Contract RecordBuilder by copying an existing Contract instance.
   * @param other The existing instance to copy.
   * @return A new Contract RecordBuilder
   */
  public static com.gft.model.Contract.Builder newBuilder(com.gft.model.Contract other) {
    return new com.gft.model.Contract.Builder(other);
  }

  /**
   * RecordBuilder for Contract instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Contract>
    implements org.apache.avro.data.RecordBuilder<Contract> {

    private int ContractId;
    private int Version;
    private double fraRate;
    private double referenceRate;
    private double notionalPrincipal;
    private boolean valid;
    private java.util.List<java.lang.CharSequence> validationResults;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.gft.model.Contract.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ContractId)) {
        this.ContractId = data().deepCopy(fields()[0].schema(), other.ContractId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Version)) {
        this.Version = data().deepCopy(fields()[1].schema(), other.Version);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fraRate)) {
        this.fraRate = data().deepCopy(fields()[2].schema(), other.fraRate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.referenceRate)) {
        this.referenceRate = data().deepCopy(fields()[3].schema(), other.referenceRate);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.notionalPrincipal)) {
        this.notionalPrincipal = data().deepCopy(fields()[4].schema(), other.notionalPrincipal);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.valid)) {
        this.valid = data().deepCopy(fields()[5].schema(), other.valid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.validationResults)) {
        this.validationResults = data().deepCopy(fields()[6].schema(), other.validationResults);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Contract instance
     * @param other The existing instance to copy.
     */
    private Builder(com.gft.model.Contract other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.ContractId)) {
        this.ContractId = data().deepCopy(fields()[0].schema(), other.ContractId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Version)) {
        this.Version = data().deepCopy(fields()[1].schema(), other.Version);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fraRate)) {
        this.fraRate = data().deepCopy(fields()[2].schema(), other.fraRate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.referenceRate)) {
        this.referenceRate = data().deepCopy(fields()[3].schema(), other.referenceRate);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.notionalPrincipal)) {
        this.notionalPrincipal = data().deepCopy(fields()[4].schema(), other.notionalPrincipal);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.valid)) {
        this.valid = data().deepCopy(fields()[5].schema(), other.valid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.validationResults)) {
        this.validationResults = data().deepCopy(fields()[6].schema(), other.validationResults);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'ContractId' field.
      * @return The value.
      */
    public java.lang.Integer getContractId() {
      return ContractId;
    }

    /**
      * Sets the value of the 'ContractId' field.
      * @param value The value of 'ContractId'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setContractId(int value) {
      validate(fields()[0], value);
      this.ContractId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ContractId' field has been set.
      * @return True if the 'ContractId' field has been set, false otherwise.
      */
    public boolean hasContractId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ContractId' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearContractId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'Version' field.
      * @return The value.
      */
    public java.lang.Integer getVersion() {
      return Version;
    }

    /**
      * Sets the value of the 'Version' field.
      * @param value The value of 'Version'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setVersion(int value) {
      validate(fields()[1], value);
      this.Version = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'Version' field has been set.
      * @return True if the 'Version' field has been set, false otherwise.
      */
    public boolean hasVersion() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'Version' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearVersion() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'fraRate' field.
      * @return The value.
      */
    public java.lang.Double getFraRate() {
      return fraRate;
    }

    /**
      * Sets the value of the 'fraRate' field.
      * @param value The value of 'fraRate'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setFraRate(double value) {
      validate(fields()[2], value);
      this.fraRate = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'fraRate' field has been set.
      * @return True if the 'fraRate' field has been set, false otherwise.
      */
    public boolean hasFraRate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'fraRate' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearFraRate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'referenceRate' field.
      * @return The value.
      */
    public java.lang.Double getReferenceRate() {
      return referenceRate;
    }

    /**
      * Sets the value of the 'referenceRate' field.
      * @param value The value of 'referenceRate'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setReferenceRate(double value) {
      validate(fields()[3], value);
      this.referenceRate = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'referenceRate' field has been set.
      * @return True if the 'referenceRate' field has been set, false otherwise.
      */
    public boolean hasReferenceRate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'referenceRate' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearReferenceRate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'notionalPrincipal' field.
      * @return The value.
      */
    public java.lang.Double getNotionalPrincipal() {
      return notionalPrincipal;
    }

    /**
      * Sets the value of the 'notionalPrincipal' field.
      * @param value The value of 'notionalPrincipal'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setNotionalPrincipal(double value) {
      validate(fields()[4], value);
      this.notionalPrincipal = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'notionalPrincipal' field has been set.
      * @return True if the 'notionalPrincipal' field has been set, false otherwise.
      */
    public boolean hasNotionalPrincipal() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'notionalPrincipal' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearNotionalPrincipal() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'valid' field.
      * @return The value.
      */
    public java.lang.Boolean getValid() {
      return valid;
    }

    /**
      * Sets the value of the 'valid' field.
      * @param value The value of 'valid'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setValid(boolean value) {
      validate(fields()[5], value);
      this.valid = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'valid' field has been set.
      * @return True if the 'valid' field has been set, false otherwise.
      */
    public boolean hasValid() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'valid' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearValid() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'validationResults' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getValidationResults() {
      return validationResults;
    }

    /**
      * Sets the value of the 'validationResults' field.
      * @param value The value of 'validationResults'.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder setValidationResults(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[6], value);
      this.validationResults = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'validationResults' field has been set.
      * @return True if the 'validationResults' field has been set, false otherwise.
      */
    public boolean hasValidationResults() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'validationResults' field.
      * @return This builder.
      */
    public com.gft.model.Contract.Builder clearValidationResults() {
      validationResults = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Contract build() {
      try {
        Contract record = new Contract();
        record.ContractId = fieldSetFlags()[0] ? this.ContractId : (java.lang.Integer) defaultValue(fields()[0]);
        record.Version = fieldSetFlags()[1] ? this.Version : (java.lang.Integer) defaultValue(fields()[1]);
        record.fraRate = fieldSetFlags()[2] ? this.fraRate : (java.lang.Double) defaultValue(fields()[2]);
        record.referenceRate = fieldSetFlags()[3] ? this.referenceRate : (java.lang.Double) defaultValue(fields()[3]);
        record.notionalPrincipal = fieldSetFlags()[4] ? this.notionalPrincipal : (java.lang.Double) defaultValue(fields()[4]);
        record.valid = fieldSetFlags()[5] ? this.valid : (java.lang.Boolean) defaultValue(fields()[5]);
        record.validationResults = fieldSetFlags()[6] ? this.validationResults : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[6]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Contract>
    WRITER$ = (org.apache.avro.io.DatumWriter<Contract>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Contract>
    READER$ = (org.apache.avro.io.DatumReader<Contract>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}