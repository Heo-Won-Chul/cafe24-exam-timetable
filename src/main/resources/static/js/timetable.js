
class TimeTable {

	constructor(aData = []) {
		this.nPosition = 0;
		this.nSize = aData.length;
		this.aData = aData;
	}

	setData(aData) {
		this.nPosition = 0;
		this.aData = aData;
		this.nSize = aData.length;
	}

	nSize() {
		return this.nSize;
	}

	isEmpty() {
		return this.nSize === 0;
	}

	current() {
		return this.aData[this.nPosition];
	}

	increment() {
		if (this.nPosition === this.nSize - 1) {
			return;
		}

		this.nPosition++;
	}

	decrement() {
		if (this.nPosition === 0) {
			return;
		}

		this.nPosition--;
	}

	format() {
		return `${this.nPosition + 1}/${this.nSize}`;
	}
}