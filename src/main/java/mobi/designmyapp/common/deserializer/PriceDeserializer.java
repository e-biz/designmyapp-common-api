/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import mobi.designmyapp.common.api.model.Price;

import java.io.IOException;

/**
 * Created by Christophe Deverre on 18/08/14.
 */
public class PriceDeserializer extends JsonDeserializer<Price> {

  @Override
  public Price deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    return new Price(jsonParser.getValueAsString());
  }
}
