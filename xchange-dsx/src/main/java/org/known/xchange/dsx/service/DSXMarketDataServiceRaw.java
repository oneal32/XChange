package org.known.xchange.dsx.service;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.known.xchange.dsx.dto.marketdata.DSXExchangeInfo;
import org.known.xchange.dsx.dto.marketdata.DSXOrderbookWrapper;
import org.known.xchange.dsx.dto.marketdata.DSXTickerWrapper;
import org.known.xchange.dsx.dto.marketdata.DSXTradesWrapper;

/**
 * @author Mikhail Wall
 */

public class DSXMarketDataServiceRaw extends DSXBaseService {

  protected static final int FULL_SIZE = 2000;

  /**
   * Constructor
   *
   * @param exchange
   */
  protected DSXMarketDataServiceRaw(Exchange exchange) {

    super(exchange);
  }

  /**
   *
   * @param pairs String of currency pairs to retrieve (e.g. "btcusd-btceur")
   * @return DSXTickerWrapper object
   * @throws IOException
   */
  public DSXTickerWrapper getDSXTicker(String pairs) throws IOException {

    return dsx.getTicker(pairs.toLowerCase(), 1);
  }

  /**
   * Get market depth from exchange
   *
   * @param pairs String of currency pairs to retrieve (e.g. "btcusd-btceur")
   * @return DSXOrderbookWrapper object
   * @throws IOException
   */
  public DSXOrderbookWrapper getDSXOrderbook(String pairs) throws IOException {

    return dsx.getOrderbook(pairs.toLowerCase(), 1);
  }

  /**
   * Get recent trades from exchange
   *
   * @param pairs String of currency pairs to retrieve (e.g. "btcusd-btceur")
   * @param size Integer value from 1 -> get corresponding number of items
   * @return DSXTradesWrapper
   * @throws IOException
   */
  public DSXTradesWrapper getDSXTrades(String pairs, int size) throws IOException {

    if (size < 1) {
      size = 1;
    }

    if (size > FULL_SIZE) {
      size = FULL_SIZE;
    }

    return dsx.getTrades(pairs.toLowerCase(), size, 1);
  }

  /**
   * Get DSX exchange info
   *
   * @return DSXExchangeInfo object
   * @throws IOException
   */
  public DSXExchangeInfo getDSXInfo() throws IOException {

    return dsx.getInfo();
  }
}
