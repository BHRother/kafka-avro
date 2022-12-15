package br.com.kafkaavro.generic.model;

public class Item {
  private String name;
  private String description;
  private Long sku;
  private Double price;

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", sku=" + sku +
        ", price=" + price +
        '}';
  }

  public Item(String name, String description, Long sku, Double price) {
    this.name = name;
    this.description = description;
    this.sku = sku;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getSku() {
    return sku;
  }

  public void setSku(Long sku) {
    this.sku = sku;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
