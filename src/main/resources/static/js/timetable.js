
class TimeTable {

	constructor(aData = []) {
		this.position = 0;
		this.size = aData.length;
		this.aData = aData;
	}

	setData(aData) {
		this.aData = aData;
		this.size = aData.length;
	}

	size() {
		return this.size;
	}

	isEmpty() {
		return this.size === 0;
	}

	current() {
		return this.aData[this.position];
	}

	increment() {
		if (this.position === this.size - 1) {
			return;
		}

		this.position++;
	}

	decrement() {
		if (this.position === 0) {
			return;
		}

		this.position--;
	}

	format() {
		return `${this.position + 1}/${this.size}`;
	}
}