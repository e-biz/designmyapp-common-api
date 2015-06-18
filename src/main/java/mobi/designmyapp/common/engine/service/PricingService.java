/*
 Copyright 2015 eBusiness Information
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package mobi.designmyapp.common.engine.service;

import mobi.designmyapp.common.engine.model.Pricing;


/**
 * This class provides pricing services
 * Created by Loïc Ortola on 24/07/14.
 */
public interface PricingService {

  /**
   * Retrieve template specific pricing
   * @param <T> output pricing instance
   * @return template pricing instance
   */
  <T extends Pricing> T getPricing();

}
