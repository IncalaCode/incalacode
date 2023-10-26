
from flask import Flask, render_template
import random

app = Flask(__name__)

# Define functions
def multiply(x, y):
 return x * y

def divide(num, divisor):
 quotient = num / divisor
 remainder = num % divisor
 return quotient, remainder

@app.route('/')
def index():
 return render_template('index.html')

if __name__ == '__main__':
 app.run()
