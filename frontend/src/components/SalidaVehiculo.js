import React, { useState } from 'react';
import './SalidaVehiculo.css'; // Archivo CSS para estilos

const SalidaVehiculo = ({ onRetirar }) => {
  const [placa, setPlaca] = useState('');

  const handleRetirar = () => {
    if (onRetirar) {
      onRetirar(placa);
    }
    setPlaca(''); // Limpiar el input después de retirar
  };

  return (
    <div className="container">
      <div className="form-wrapper">
        <h1>Salida de vehículo</h1>
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
          <div className="button-group">
            <button type="button" onClick={handleRetirar} className="btn">
              Retirar
            </button>
          </div>
        </form>
        <footer>www.iuparking.com</footer>
      </div>
    </div>
  );
};

export default SalidaVehiculo;