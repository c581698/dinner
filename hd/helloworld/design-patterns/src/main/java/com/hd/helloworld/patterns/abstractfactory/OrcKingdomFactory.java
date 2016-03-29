package com.hd.helloworld.patterns.abstractfactory;

/**
 * 抽象工厂实例
* @ClassName: OrcKingdomFactory
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年3月30日 上午12:50:16
*
 */
public class OrcKingdomFactory implements KingdomFactory {

	@Override
	public Castle createCastle() {
		return new OrcCastle();
	}

	@Override
	public King createKing() {
		return new OrcKing();
	}

	@Override
	public Army createArmy() {
		return new OrcArmy();
	}

}
