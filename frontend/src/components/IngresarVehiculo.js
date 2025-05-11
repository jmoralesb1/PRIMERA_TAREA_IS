import React, { useState } from 'react';
import './IngresarVehiculo.css';

const IngresarVehiculo = ({ onIngresar, onSalir }) => {
  const [placa, setPlaca] = useState('');
  const [tipo, setTipo] = useState('');
  const [color, setColor] = useState('');

  const handleIngresar = () => {
    if (onIngresar) {
      onIngresar({ placa, tipo, color });
    }
    setPlaca('');
    setTipo('');
    setColor('');
  };

  const handleSalir = () => {
    if (onSalir) {
      onSalir();
    }
  };

  return (
    <div className="container">
      <div className="form-wrapper">
        <h1>Ingresar vehículo</h1>
        <form>
          <div className="input-group">
            <label htmlFor="placa">Placa</label>
            <input
              type="text"
              id="placa"
              value={placa}
              onChange={(e) => setPlaca(e.target.value)}
              placeholder="Placa"
            />
          </div>
          <div className="input-group">
            <label htmlFor="tipo">Tipo</label>
            <input
              type="text"
              id="tipo"
              value={tipo}
              onChange={(e) => setTipo(e.target.value)}
              placeholder="Tipo"
            />
          </div>
          <div className="input-group">
            <label htmlFor="color">Color</label>
            <input
              type="text"
              id="color"
              value={color}
              onChange={(e) => setColor(e.target.value)}
              placeholder="Color"
            />
          </div>
          <div className="button-group">
            <button type="button" onClick={handleIngresar} className="btn">
              Ingresar
            </button>
            <button type="button" onClick={handleSalir} className="btn">
              Salir
            </button>
          </div>
        </form>
        <footer>www.iuparking.com</footer>
      </div>
    </div>
  );
};

export default IngresarVehiculo;