/**
 * Copyright 2011 Alexey Ragozin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gridkit.coherence.search.timeseries;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.DefaultConfigurableCacheFactory;
import com.tangosol.net.PartitionedService;

/**
 * @author Alexey Ragozin (alexey.ragozin@gmail.com)
 */
@RunWith(Suite.class)
@SuiteClasses({
	BasicFunctional_TestSet.class,
	SimpleAggregation_TestSet.class,
	RandomAggregation_TestSet.class
})
public class DistributedCache_SuiteTest {

	static {
		CacheFactory.setConfigurableCacheFactory(new DefaultConfigurableCacheFactory("test-cache-config.xml"));
	}	
	
	@BeforeClass
	public static void init(){
		AbstractTimeseriesFunctional_TestSet.testCache = CacheFactory.getCache("distributed-cache");
		AbstractTimeseriesFunctional_TestSet.useAffinity = true;
	}

	@Test
	public void cacheType() {
		Assert.assertTrue(AbstractTimeseriesFunctional_TestSet.testCache.getCacheService() instanceof PartitionedService);
	}	
}
