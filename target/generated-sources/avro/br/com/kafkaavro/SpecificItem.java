/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package br.com.kafkaavro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SpecificItem extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2415414007523902756L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SpecificItem\",\"namespace\":\"br.com.kafkaavro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the item\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"sku\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SpecificItem> ENCODER =
      new BinaryMessageEncoder<SpecificItem>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SpecificItem> DECODER =
      new BinaryMessageDecoder<SpecificItem>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<SpecificItem> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<SpecificItem> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SpecificItem>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this SpecificItem to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a SpecificItem from a ByteBuffer. */
  public static SpecificItem fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** name of the item */
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence description;
  @Deprecated public long sku;
  @Deprecated public double price;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SpecificItem() {}

  /**
   * All-args constructor.
   * @param name name of the item
   * @param description The new value for description
   * @param sku The new value for sku
   * @param price The new value for price
   */
  public SpecificItem(java.lang.CharSequence name, java.lang.CharSequence description, java.lang.Long sku, java.lang.Double price) {
    this.name = name;
    this.description = description;
    this.sku = sku;
    this.price = price;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return description;
    case 2: return sku;
    case 3: return price;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: description = (java.lang.CharSequence)value$; break;
    case 2: sku = (java.lang.Long)value$; break;
    case 3: price = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return name of the item
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * name of the item
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'sku' field.
   * @return The value of the 'sku' field.
   */
  public java.lang.Long getSku() {
    return sku;
  }

  /**
   * Sets the value of the 'sku' field.
   * @param value the value to set.
   */
  public void setSku(java.lang.Long value) {
    this.sku = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.Double getPrice() {
    return price;
  }

  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.Double value) {
    this.price = value;
  }

  /**
   * Creates a new SpecificItem RecordBuilder.
   * @return A new SpecificItem RecordBuilder
   */
  public static br.com.kafkaavro.SpecificItem.Builder newBuilder() {
    return new br.com.kafkaavro.SpecificItem.Builder();
  }

  /**
   * Creates a new SpecificItem RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SpecificItem RecordBuilder
   */
  public static br.com.kafkaavro.SpecificItem.Builder newBuilder(br.com.kafkaavro.SpecificItem.Builder other) {
    return new br.com.kafkaavro.SpecificItem.Builder(other);
  }

  /**
   * Creates a new SpecificItem RecordBuilder by copying an existing SpecificItem instance.
   * @param other The existing instance to copy.
   * @return A new SpecificItem RecordBuilder
   */
  public static br.com.kafkaavro.SpecificItem.Builder newBuilder(br.com.kafkaavro.SpecificItem other) {
    return new br.com.kafkaavro.SpecificItem.Builder(other);
  }

  /**
   * RecordBuilder for SpecificItem instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SpecificItem>
    implements org.apache.avro.data.RecordBuilder<SpecificItem> {

    /** name of the item */
    private java.lang.CharSequence name;
    private java.lang.CharSequence description;
    private long sku;
    private double price;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(br.com.kafkaavro.SpecificItem.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sku)) {
        this.sku = data().deepCopy(fields()[2].schema(), other.sku);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SpecificItem instance
     * @param other The existing instance to copy.
     */
    private Builder(br.com.kafkaavro.SpecificItem other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sku)) {
        this.sku = data().deepCopy(fields()[2].schema(), other.sku);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * name of the item
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * name of the item
      * @param value The value of 'name'.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * name of the item
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * name of the item
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public java.lang.CharSequence getDescription() {
      return description;
    }

    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.description = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder clearDescription() {
      description = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'sku' field.
      * @return The value.
      */
    public java.lang.Long getSku() {
      return sku;
    }

    /**
      * Sets the value of the 'sku' field.
      * @param value The value of 'sku'.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder setSku(long value) {
      validate(fields()[2], value);
      this.sku = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'sku' field has been set.
      * @return True if the 'sku' field has been set, false otherwise.
      */
    public boolean hasSku() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'sku' field.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder clearSku() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.Double getPrice() {
      return price;
    }

    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder setPrice(double value) {
      validate(fields()[3], value);
      this.price = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public br.com.kafkaavro.SpecificItem.Builder clearPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SpecificItem build() {
      try {
        SpecificItem record = new SpecificItem();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.description = fieldSetFlags()[1] ? this.description : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.sku = fieldSetFlags()[2] ? this.sku : (java.lang.Long) defaultValue(fields()[2]);
        record.price = fieldSetFlags()[3] ? this.price : (java.lang.Double) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SpecificItem>
    WRITER$ = (org.apache.avro.io.DatumWriter<SpecificItem>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SpecificItem>
    READER$ = (org.apache.avro.io.DatumReader<SpecificItem>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}