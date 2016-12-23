/**
 * 
 */
package com.brain.study.patterns.decorator;

/**
 * Decorator
 * 动态的为对象添加额外的职责
 * @author Brain
 * @date 2014-12-7
 */
public class Decorator implements Component {

	protected Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {
		if (this.component != null) {
			this.component.operation();
		}
	}
}
