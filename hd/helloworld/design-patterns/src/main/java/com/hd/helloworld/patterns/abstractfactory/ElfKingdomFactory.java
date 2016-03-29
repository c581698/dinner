package com.hd.helloworld.patterns.abstractfactory;
/**
 * 抽象工厂实例
* @ClassName: ElfKingdomFactory
* @Description: TODO
* @author chs cyj91516@aliyun.com
* @date 2016年3月30日 上午12:48:21
*
 */
public class ElfKingdomFactory implements KingdomFactory {

	@Override
	public Castle createCastle() {
		return new ElfCastle();
	}

	@Override
	public King createKing() {
		return new ElfKing();
	}

	@Override
	public Army createArmy() {
		return new ElfArmy();
	}

}
